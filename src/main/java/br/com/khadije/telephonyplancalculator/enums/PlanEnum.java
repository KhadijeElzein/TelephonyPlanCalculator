package br.com.khadije.telephonyplancalculator.enums;

public enum PlanEnum {
	FaleMais30(1), 
	FaleMais60(2),
	FaleMais120(3);
	
	private Integer codigo;
	
	private PlanEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}	
}
