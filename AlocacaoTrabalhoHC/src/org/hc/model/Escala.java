package org.hc.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hc.enums.DiaDaSemana;
import org.hc.enums.Turno;


public class Escala {
	
	private Date data;
	private List<Perfil> perfis;
	private Setor setor;
	
	
	public void addPerfil(Perfil p){
		perfis.add(p);
	}

	
	//setters and getters
	public Date getData() {
		return data;
	}
	
	
	public void setData(Date data) {
		this.data = data;
	}
	
	
	public List<Perfil> getPerfis() {
		return perfis;
	}
	
	
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	
	public Setor getSetor() {
		return setor;
	}
	
	
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	

}
