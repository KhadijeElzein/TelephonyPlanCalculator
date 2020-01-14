package br.com.khadije.telephonyplancalculator.resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.khadije.telephonyplancalculator.entity.CallData;
import br.com.khadije.telephonyplancalculator.entity.Result;
import br.com.khadije.telephonyplancalculator.exception.ApiExceptionHandler;
import br.com.khadije.telephonyplancalculator.facade.TelephonyPlanCalculatorFacade;


@TestInstance(Lifecycle.PER_CLASS)
public class TelephonyPlanCalculatorResourceTest {
	private MockMvc mockMvc;
	
	@Mock
	private TelephonyPlanCalculatorFacade facade;
	
	@InjectMocks
	private TelephonyPlanCalculatorResource controller;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(new ApiExceptionHandler()).build();
	}

	private ResultActions doPost(String request) throws Exception {
		return this.mockMvc.perform(post("/v1.0/telephony-plan-calculator/compute").
				contentType(MediaType.APPLICATION_JSON).
				content(request)).andDo(print());
                
	}
	private String mapToJson(CallData data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    return ow.writeValueAsString(data);
	}
	
	@Test
	public void computePriceTelephonyPlanValidData() throws Exception {
		String source = "011";
		String destination = "016";
		Double minutes = 20d;
		Integer plan = 1;
		CallData data =new CallData(source,destination,minutes,plan);
		Result result = new Result();
		result.setPriceWithoutPlan(38d);
		result.setPriceWithPlan(0d);
		
		String request = mapToJson(data);
	 
	    when(facade.computeCallPrice(any(CallData.class)))
		.thenReturn(result);

	    doPost(request).
	    andExpect(status().isOk())
	    .andExpect(jsonPath("$.priceWithoutPlan").value(38d))
	    .andExpect(jsonPath("$.priceWithPlan").value(0d));
		
	}
	
	@Test
	public void computePriceTelephonyPlanInvalidDDD() throws Exception {
		String source = "011";
		String destination = "011";
		Double minutes = 20d;
		Integer plan = 1;
		CallData data =new CallData(source,destination,minutes,plan);
		
		String request = mapToJson(data);
	 
	    when(facade.computeCallPrice(any(CallData.class)))
		.thenReturn(null);
	
		doPost(request).
		andExpect(status().isNoContent());
	}
	
	@Test
	public void computePriceTelephonyPlanNegativeMinutes() throws Exception {
		String source = "011";
		String destination = "016";
		Double minutes = -20d;
		Integer plan = 1;
		CallData data =new CallData(source,destination,minutes,plan);
		
		String request = mapToJson(data);
	 
	    when(facade.computeCallPrice(any(CallData.class)))
		.thenReturn(null);
	
		doPost(request).
		andExpect(status().isPreconditionFailed());
		
	}
	
	@Test
	public void computePriceTelephonyPlanNullValues() throws Exception {
		String source = null;
		String destination = null;
		Double minutes = null;
		Integer plan = null;
		CallData data =new CallData(source,destination,minutes,plan);
		
		String request = mapToJson(data);
	 
	    when(facade.computeCallPrice(any(CallData.class)))
		.thenReturn(null);
	
		doPost(request).
		andExpect(status().isPreconditionFailed());
		
	}
	
	@Test
	public void computePriceTelephonyPlanInvalidPlan() throws Exception {
		String source = "011";
		String destination = "016";
		Double minutes = 20d;
		Integer plan = 4;
		CallData data =new CallData(source,destination,minutes,plan);
		
		String request = mapToJson(data);
	 
	    when(facade.computeCallPrice(any(CallData.class)))
		.thenReturn(null);
	
		doPost(request).
		andExpect(status().isNoContent());
	}

}
