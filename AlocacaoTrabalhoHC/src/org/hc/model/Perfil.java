package org.hc.model;

import java.util.HashMap;
import java.util.Map;

import org.hc.enums.DiaDaSemana;
import org.hc.enums.Turno;

public class Perfil {
	
	private static int id = 0;
	
	private String senha;
	private Map<DiaDaSemana, Turno> horarios;
	private String descricao;
	private Funcionario funcionario;
	
	
	public Perfil(){
		this.horarios = new HashMap<DiaDaSemana, Turno>();
	}
	
	
	public void setHorarios(DiaDaSemana dia, Turno turno){
		horarios.put(dia, turno);
	}
	
	
	public Map<DiaDaSemana, Turno> getHorarios(){
		return horarios;
	}
	
	
	public void cadHorarios(Map<DiaDaSemana, Turno> h){
		horarios.putAll(h);
	}
	
	
	public static void incId(){
		id++;
	}
	
	
	public static void decId(){
		id--;
	}
	

}
