package br.com.khadije.telephonyplancalculator.facade;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.khadije.telephonyplancalculator.entity.CallData;
import br.com.khadije.telephonyplancalculator.entity.Result;

@TestInstance(Lifecycle.PER_CLASS)
public class TelephonyPlanCalculatorFacadeTest {
	
	@InjectMocks
	private TelephonyPlanCalculatorFacade facade;
	
	@BeforeAll
	private void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void computeCallPriceValidData() {
		String source = "011";
		String destination = "016";
		Double minutes = 20d;
		Integer plan = 1;
		CallData data =new CallData(source,destination,minutes,plan);
		Result result = facade.computeCallPrice(data);
		assertEquals(result.getPriceWithoutPlan(),38d);
		assertEquals(result.getPriceWithPlan(),0d);
	}
	
	@Test
	public void computeCallPriceInvalidDDD() {
		String source = "011";
		String destination = "011";
		Double minutes = 20d;
		Integer plan = 1;
		CallData data =new CallData(source,destination,minutes,plan);
		Result result = facade.computeCallPrice(data);
		assertNull(result);
	}
	
	@Test
	public void computeCallPriceNegativeMinutes() {
		String source = "011";
		String destination = "016";
		Double minutes = -20d;
		Integer plan = 1;
		CallData data =new CallData(source,destination,minutes,plan);
		Result result = facade.computeCallPrice(data);
		assertNull(result);
	}
	
	@Test
	public void computeCallPriceZeroMinutes() {
		String source = "011";
		String destination = "016";
		Double minutes = 0d;
		Integer plan = 1;
		CallData data =new CallData(source,destination,minutes,plan);
		Result result = facade.computeCallPrice(data);
		assertEquals(result.getPriceWithoutPlan(),0d);
		assertEquals(result.getPriceWithPlan(),0d);
	}
	
	@Test
	public void computeCallPriceNullValues() {
		String source = null;
		String destination = null;
		Double minutes = null;
		Integer plan = null;
		CallData data =new CallData(source,destination,minutes,plan);
		Result result = facade.computeCallPrice(data);
		assertNull(result);
	}
	
	@Test
	public void computeCallPriceInvalidPlan() {
		String source = "011";
		String destination = "016";
		Double minutes = 20d;
		Integer plan = 4;
		CallData data =new CallData(source,destination,minutes,plan);
		Result result = facade.computeCallPrice(data);
		assertNull(result.getPriceWithPlan());
	}
}
