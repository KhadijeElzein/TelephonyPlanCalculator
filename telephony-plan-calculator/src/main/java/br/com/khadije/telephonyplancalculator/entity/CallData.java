package br.com.khadije.telephonyplancalculator.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallData {
	private String source;
	private String destination;
	private Double minutes;
	private Integer plan;
}
