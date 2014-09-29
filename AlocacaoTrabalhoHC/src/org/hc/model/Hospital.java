package org.hc.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	
	private final String nome;
	private List<Setor> setores;
	private static Hospital instance;
	
	
	private Hospital(){
		
		setores = new ArrayList<Setor>();
		nome = "Hospital das Clinicas";
		
	}
	
	
	public static Hospital getInstance(){
		
		if (instance == null)
			instance = new Hospital();
			
		return instance;
		
	}
	
	
	public boolean cadastrarSetor(Setor s){
		return setores.add(s);
	}
	

	public String getNome() {
		return nome;
	}
	

}
