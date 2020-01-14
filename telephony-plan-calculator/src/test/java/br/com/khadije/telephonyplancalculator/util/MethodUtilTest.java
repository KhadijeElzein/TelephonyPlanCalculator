package br.com.khadije.telephonyplancalculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MethodUtilTest {
	
	private MethodUtil methodUtil;
	@BeforeEach
	public void preparaDados() {
		this.methodUtil = new MethodUtil();
	}
	
	@Test
	public void computePriceCallWithoutPlanValidData() {
		Double minutes = 20d;
		Double pricePerMinute = 1.90d;
		Double result = methodUtil.computePriceCallWithoutPlan(minutes, pricePerMinute);
		assertEquals(result,38d);
	}
	
	@Test
	public void computePriceCallWithoutPlanNegativeMinutes() {
		Double minutes = -20d;
		Double pricePerMinute = 1.90d;
		Double result = methodUtil.computePriceCallWithoutPlan(minutes, pricePerMinute);
		assertNull(result);
	}
	
	@Test
	public void computePriceCallWithoutPlanNegativePricePerMinute() {
		Double minutes = 20d;
		Double pricePerMinute = -1.90d;
		Double result = methodUtil.computePriceCallWithoutPlan(minutes, pricePerMinute);
		assertNull(result);
		
	}
	
	@Test
	public void computePriceWithoutPlanNullValues() {
		Double minutes = null;
		Double pricePerMinute = null;
		Double result = methodUtil.computePriceCallWithoutPlan(minutes, pricePerMinute);
		assertNull(result);
	}
	
	@Test
	public void computePriceWithoutPlanNullMinutes() {
		Double minutes = null;
		Double pricePerMinute = 1.90d;
		Double result = methodUtil.computePriceCallWithoutPlan(minutes, pricePerMinute);
		assertNull(result);
	}
	
	@Test
	public void computePriceWithoutPlanNullPricePerMinute() {
		Double minutes = 20d;
		Double pricePerMinute = null;
		Double result = methodUtil.computePriceCallWithoutPlan(minutes, pricePerMinute);
		assertNull(result);
	}
	
	@Test
	public void computePriceCallWithPlanValidDataLessMinutesPlan1() {
		Double minutes = 20d;
		Double pricePerMinute = 1.90d;
		Integer plan = 1;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertEquals(result,0d);
	}
	
	@Test
	public void computePriceCallWithPlanValidDataMoreMinutesPlan1() {
		Double minutes = 40d;
		Double pricePerMinute = 1.90d;
		Integer plan = 1;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertEquals(result,20.9d);
	}
	
	@Test
	public void computePriceCallWithPlanValidDataLessMinutesPlan2() {
		Double minutes = 20d;
		Double pricePerMinute = 1.90d;
		Integer plan = 2;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertEquals(result,0d);
	}
	
	@Test
	public void computePriceCallWithPlanValidDataMoreMinutesPlan2() {
		Double minutes = 80d;
		Double pricePerMinute = 1.90d;
		Integer plan = 2;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertEquals(result,41.8d);
	}
	
	@Test
	public void computePriceCallWithPlanValidDataLessMinutesPlan3() {
		Double minutes = 20d;
		Double pricePerMinute = 1.90d;
		Integer plan = 3;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertEquals(result,0d);
	}
	
	@Test
	public void computePriceCallWithPlanValidDataMoreMinutesPlan3() {
		Double minutes = 200d;
		Double pricePerMinute = 1.90d;
		Integer plan = 3;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertEquals(result,167.2d);
	}
	
	@Test
	public void computePriceCallWithPlanNegativeMinutes() {
		Double minutes = -20d;
		Double pricePerMinute = 1.90d;
		Integer plan = 1;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertNull(result);
		
	}
	
	@Test
	public void computePriceCallWithPlanNegativePricePerMinute() {
		Double minutes = 20d;
		Double pricePerMinute = -1.90d;
		Integer plan = 1;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertNull(result);
	}
	
	@Test
	public void computePriceCallWithPlanInvalidPlan() {
		Double minutes = 20d;
		Double pricePerMinute = 1.90d;
		Integer plan = 4;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertNull(result);
	}
	
	@Test
	public void computePriceCallWithPlanNullMinutes() {
		Double minutes = null;
		Double pricePerMinute = 1.90d;
		Integer plan = 1;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertNull(result);
	}
	
	@Test
	public void computePriceCallWithPlanNullPricePerMinute() {
		Double minutes = 20d;
		Double pricePerMinute = null;
		Integer plan = 1;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertNull(result);
	}
	
	@Test
	public void computePriceCallWithPlanNullPlan() {
		Double minutes = 20d;
		Double pricePerMinute = 1.90d;
		Integer plan = null;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertNull(result);
	}
	
	@Test
	public void computePriceCallWithPlanNullValues() {
		Double minutes = null;
		Double pricePerMinute = null;
		Integer plan = null;
		Double result = methodUtil.computePriceCallWithPlan(minutes, pricePerMinute,plan);
		assertNull(result);
	}
	
}
