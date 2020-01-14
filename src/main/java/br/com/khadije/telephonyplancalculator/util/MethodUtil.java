package br.com.khadije.telephonyplancalculator.util;

import br.com.khadije.telephonyplancalculator.enums.PlanEnum;

public class MethodUtil {
	
	public Double computePriceCallWithoutPlan(Double minutes, Double pricePerMinute) {
		if(pricePerMinute!=null && minutes!=null) {
			if(pricePerMinute < 0 || minutes < 0 )
				return null;
			return pricePerMinute*minutes;
		}
		return null;
	}
	public Double computePriceCallWithPlan(Double minutes, Double pricePerMinute, Integer plan) {
		if(minutes!=null && pricePerMinute!= null && plan!=null) {
			if(pricePerMinute < 0 || minutes < 0 )
				return null;
			if(plan == PlanEnum.FaleMais30.getCodigo()) {
				if(minutes > 30) 
					return (minutes-30)*(pricePerMinute+(pricePerMinute*0.1));
				else return 0d;
			}
			if(plan == PlanEnum.FaleMais60.getCodigo()) {
				if(minutes > 60) 
					return (minutes-60)*(pricePerMinute+(pricePerMinute*0.1));
				else return 0d;
			}
			if(plan == PlanEnum.FaleMais120.getCodigo()) {
				if(minutes > 120) 
					return (minutes-120)*(pricePerMinute+(pricePerMinute*0.1));
				else return 0d;
			}
		}
		return null;
	}
}
