package org.hc.model;

import java.util.List;

import org.hc.enums.Mes;

public class Setor {
	
	private String nome;
	private int andar;
	private List<Escala> escalas;
	private List<Funcionario> funcionarios;
	private Funcionario responsavel;
	
	
	public void cadFuncionario(Funcionario f){
		funcionarios.add(f);
	}
	
	
	public void alocarFuncionarios(){
		//TODO
	}
	

	public void mostrarEscala(Mes m){
		//TODO
	}
	
	
	public void mostrarEscala(Perfil p){
		//TODO
	}
	
	
	public void setFuncionario(Funcionario f){
		responsavel = f;
	}
	
	
	
}
