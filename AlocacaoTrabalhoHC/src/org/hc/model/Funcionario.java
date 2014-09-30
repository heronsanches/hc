package org.hc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hc.enums.DiaDaSemana;
import org.hc.enums.Turno;

public class Funcionario {
	
	private String cpf;
	private String cep;
	private String email;
	private char sexo;
	private String telefone;
	private List<Perfil> perfis;
	
	
	public Funcionario(){
		perfis = new ArrayList<Perfil>();
	}
	
	
	public void addPerfil(Perfil p){
		perfis.add(p);
	}
	

	public Map<DiaDaSemana, Turno> listarHorarios(Perfil p){
		
		if(perfis.contains(p))
			return p.getHorarios();
		
		return null;
	}
	
	
	//getters and setters
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public List<Perfil> getPerfis() {
		return perfis;
	}

	/*
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}*/
	

}
