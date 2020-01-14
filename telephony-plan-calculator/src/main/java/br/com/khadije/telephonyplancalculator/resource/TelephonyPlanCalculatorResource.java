package br.com.khadije.telephonyplancalculator.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.khadije.telephonyplancalculator.entity.CallData;
import br.com.khadije.telephonyplancalculator.entity.Result;
import br.com.khadije.telephonyplancalculator.exception.NoContentException;
import br.com.khadije.telephonyplancalculator.facade.TelephonyPlanCalculatorFacade;

@RestController
@CrossOrigin
@RequestMapping(path = "/v1.0/telephony-plan-calculator", produces = MediaType.APPLICATION_JSON_VALUE)
public class TelephonyPlanCalculatorResource {
	@Autowired
	TelephonyPlanCalculatorFacade facade;
	@PostMapping(value="/compute")
	public ResponseEntity<Result> computePriceTelephonyPlan(@RequestBody CallData data){
		if(data.getSource() == null || data.getDestination() == null 
		   || data.getPlan() == null || data.getMinutes() == null || data.getMinutes() < 0)
				throw new IllegalArgumentException();
		Result result  = facade.computeCallPrice(data);
		if(result==null)
			throw new NoContentException();
		return ResponseEntity.ok(result);
	    }
}
