package org.hc.model;

import java.util.ArrayList;
import java.util.List;

import org.hc.enums.Mes;

public class Setor {
	
	private String nome;
	private int andar;
	private List<Escala> escalas;
	private List<Funcionario> funcionarios;
	private Funcionario responsavel;
	
	
	public Setor(){
		
		escalas = new ArrayList<Escala>();
		funcionarios = new ArrayList<Funcionario>();
		
	}
	
	
	public boolean cadFuncionario(Funcionario f){
		
		if(f == null)
			return false;
		
		return funcionarios.add(f);
	}
	
	
	public void alocarFuncionarios(){
		//TODO
	}
	
	/**
	 * Mostra escala mensal de todos os funcionarios do setor.
	 * 
	 */
	public void mostrarEscala(Mes m){
		//TODO
	}
	
	/**
	 * Mostra escala referente a um perfil do funcionario do setor, assim como quem ira trabalhar
	 * com este funcionario.
	 * 
	 */
	public void mostrarEscala(Perfil p){
		//TODO
	}
	
	
	public void setResponsavel(Funcionario f){
		responsavel = f;
	}
	
	
	public Funcionario getResponsavel(){
		return responsavel;
	}


	public List<Escala> getEscalas() {
		return escalas;
	}

	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
