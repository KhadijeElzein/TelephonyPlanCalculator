package br.com.khadije.telephonyplancalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price{
	private String origin;
	private String destination;
	private Double price;
	

	
}
