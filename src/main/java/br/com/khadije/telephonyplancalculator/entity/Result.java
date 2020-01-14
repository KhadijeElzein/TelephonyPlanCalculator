package br.com.khadije.telephonyplancalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
	private Double priceWithoutPlan;
	private Double priceWithPlan;
}