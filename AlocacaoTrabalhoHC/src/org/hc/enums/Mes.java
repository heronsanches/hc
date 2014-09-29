package org.hc.enums;

public enum Mes {
	
	JANEIRO("Janeiro"),
	FEVEREIRO("Fevereiro"),
	MARCO("Março"),
	ABRIL("Abril"),
	MAIO("Maio"),
	JUNHO("Junho"),
	JULHO("Julho"),
	AGOSTO("Agosto"),
	SETEMBRO("Setembro"),
	OUTUBRO("Outubro"),
	NOVEMBRO("Novembro"),
	DEZEMBRO("Dezembro");
	
	
	private final String mes;
	
	
	private Mes(String mes){
		this.mes = mes;
	}

	
	public String getMes(){
		return mes;
	}
	
	
}
