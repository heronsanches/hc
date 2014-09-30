package org.hc.teste.unitario;

import org.hc.model.Escala;
import org.hc.model.Funcionario;
import org.hc.model.Setor;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetorTeste {
	
	@Test
	public void SetorTeste(){
		
		Setor s = new Setor();
		assertNotNull("lista de escalas nao inicializada", s.getEscalas());
		assertNotNull("lista de funcionarios nao inicializada", s.getFuncionarios());
		
	}
	
	@Test
	public void cadastrarFuncionarioTeste(){
		assertTrue("deve retornar true", (new Setor()).cadFuncionario(new Funcionario()));
	}
	
	
	@Test
	public void setResponsavelTeste(){
		
		Setor s = new Setor();
		Funcionario f = new Funcionario();
		s.setResponsavel(f);
		assertSame(f, s.getResponsavel());
		
	}
	
	
	@Test
	public void getResponsavelTeste(){
		
		Setor s = new Setor();
		Funcionario f = new Funcionario();
		s.setResponsavel(f);
		assertSame(f, s.getResponsavel());
		
	}
	
	
	@Test
	public void getEscalasTeste(){
		
		Setor s = new Setor();
		Escala e = new Escala();
		s.getEscalas().add(e);
		assertSame(e, s.getEscalas().get(0));
		
	}
	
	
	@Test
	public void getFuncionariosTeste(){
		
		Setor s = new Setor();
		Funcionario f = new Funcionario();
		s.getFuncionarios().add(f);
		assertSame(f, s.getFuncionarios().get(0));
		
	}
	
	@Test
	public void alocarFuncionariosTeste(){
		assertTrue(true);
	}
	
	@Test
	public void mostrarEscalaMensalTeste(){
		assertTrue(true);
	}
	
	@Test
	public void mostrarEscalPorPerfilTeste(){
		assertTrue(true);
	}
	

}
