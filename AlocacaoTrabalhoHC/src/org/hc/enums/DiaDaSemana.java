package org.hc.enums;

public enum DiaDaSemana {
	
	SEG("Segunda-Feira"), 
	TER("Terça-Feira"), 
	QUA("Quarta-Feira"), 
	QUI("Quinta-Feira"),
	SEX("Sexta-Feira"),
	SAB("Sábado"),
	DOM("Domingo");
	
	
	private final String dia;
	
	
	private DiaDaSemana(String dia) {
		
		this.dia = dia;

	}
	
	
	public String getDia(){
		
		return dia;
		
	}
	

}
