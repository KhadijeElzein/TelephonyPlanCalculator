package br.com.khadije.telephonyplancalculator.facade;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.khadije.telephonyplancalculator.entity.CallData;
import br.com.khadije.telephonyplancalculator.entity.Price;
import br.com.khadije.telephonyplancalculator.entity.PriceList;
import br.com.khadije.telephonyplancalculator.entity.Result;
import br.com.khadije.telephonyplancalculator.util.MethodUtil;

@Service
@Component
public class TelephonyPlanCalculatorFacade {

	public Result computeCallPrice(CallData data) {
		MethodUtil util = new MethodUtil();
		PriceList priceList = new PriceList();
		if(data.getDestination()!=null && data.getMinutes()!=null && data.getPlan()!=null && data.getSource()!=null) {
			Price price = priceList.getPrice(data.getSource(), data.getDestination());
			if(price!=null && data.getMinutes() >=0) {
				Double priceWithoutPlan = util.computePriceCallWithoutPlan(data.getMinutes(), price.getPrice());
				Double priceWithPlan = util.computePriceCallWithPlan(data.getMinutes(),price.getPrice(),data.getPlan());
				return new Result(priceWithoutPlan, priceWithPlan);
			}
		}
		return null;
	}

}
