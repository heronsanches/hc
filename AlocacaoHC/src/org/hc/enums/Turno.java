package org.hc.enums;

public enum Turno {
	
	MATUTINO("Matutino"),
	VESPERTINO("Vespertino");
	//NOTURNO("Noturno"),
	//MADRUGADA("Madrugada");
	
	
	private final String turno;
	
	
	private Turno(String turno) {
		
		this.turno = turno;
		
	}
	
	
	public String getTurno(){
		
		return turno;
	
	}
	
	
	

}
