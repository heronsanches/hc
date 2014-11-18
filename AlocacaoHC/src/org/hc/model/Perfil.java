package org.hc.model;

import java.util.HashMap;
import java.util.Map;

import org.hc.enums.DiaDaSemana;
import org.hc.enums.Turno;

public class Perfil {
	
	private String senha;
	private Map<DiaDaSemana, Turno> horarios;
	private String descricao;
	private Funcionario funcionario;
	private boolean ativo;
	
	
	public Perfil(){
		
		horarios = new HashMap<DiaDaSemana, Turno>();
		
		for(DiaDaSemana d: DiaDaSemana.values())				
				horarios.put(d, null);

	}
	
	
	public void addHorario(DiaDaSemana dia, Turno turno){
		horarios.put(dia, turno);
	}
	
	
	public Map<DiaDaSemana, Turno> getHorarios(){
		return horarios;
	}
	
}
