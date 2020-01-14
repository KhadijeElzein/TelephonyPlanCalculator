package br.com.khadije.telephonyplancalculator.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PriceList {
	private static List<Price> prices = Arrays.asList(
			new Price("011","016",1.90),
			new Price("016","011",2.90),
			new Price("011","017",1.70),
			new Price("017","011",2.70),
			new Price("011","018",0.90),
			new Price("018","011",1.90)
			);
	public Price getPrice(String origin, String destination) {
		Optional<Price> price = 
				prices.stream()
					.filter(p -> (p.getOrigin().compareToIgnoreCase(origin) == 0)
							&& (p.getDestination().compareToIgnoreCase(destination) == 0)).findFirst();
		
		if (price.isPresent()) {
			return price.get();
		}
		return null;
	}
}
