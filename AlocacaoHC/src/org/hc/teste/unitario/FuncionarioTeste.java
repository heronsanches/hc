package org.hc.teste.unitario;

import org.hc.model.Funcionario;
import org.hc.model.Perfil;
import org.junit.Test;

import static org.junit.Assert.*;

public class FuncionarioTeste {
	
	@Test
	public void FuncionarioTeste(){
		
		Funcionario f = new Funcionario();
		assertNotNull("lista de perfis nao foi inicializada", f.getPerfis());
	
	}

	
	@Test
	public void addPerfilTeste(){
		
		Funcionario f = new Funcionario();
		Perfil p = new Perfil();
		f.addPerfil(p);
		assertTrue("objeto nao foi inserido", f.getPerfis().contains(p) 
				&& f.getPerfis().size() == 1);
		
	}
	
	@Test
	public void listarHorariosTeste(){
		
		Funcionario f = new Funcionario();
		Perfil p = new Perfil();
		
		assertNull("deve retornar null, para dizer que este perfil nao e deste funcionario",
				f.listarHorarios(p));
		
		f.addPerfil(p);
		
		assertNotNull("deveria retornar alguma lista de horario para este perfil, mesmo que nula",
				f.getPerfis().get(0).getHorarios());

	}
	
	
	@Test
	public void getCpfTeste(){
		
		Funcionario f = new Funcionario();
		f.setCpf("cpf");
		assertSame("cpf", f.getCpf());
		
	}
	
	
	@Test
	public void setCpfTeste(){
		
		getCpfTeste();
		
	}
	
	
	@Test
	public void getCepTeste() {
		
		Funcionario f = new Funcionario();
		f.setCep("cep");
		assertSame("cep", f.getCep());
	
	}


	@Test
	public void setCepTeste() {
		
		getCepTeste();
		
	}
	
	
	@Test
	public void getEmailTeste() {
		
		Funcionario f = new Funcionario();
		f.setEmail("email");
		assertSame("email", f.getEmail());
	
	}


	@Test
	public void setEmailTeste() {
		
		getEmailTeste();
		
	}
	
	
	@Test
	public void getSexoTeste() {
		
		Funcionario f = new Funcionario();
		f.setSexo('s');
		assertSame('s', f.getSexo());
	
	}


	@Test
	public void setSexoTeste() {
		
		getSexoTeste();
		
	}
	
	
	@Test
	public void getTelefoneTeste() {
		
		Funcionario f = new Funcionario();
		f.setTelefone("telefone");
		assertSame("telefone", f.getTelefone());
	
	}


	@Test
	public void setTelefoneTeste() {
		
		getTelefoneTeste();
		
	}
	
	@Test
	public void getPerfisTeste(){
		
		Funcionario f = new Funcionario();
		Perfil p = new Perfil();
		f.addPerfil(p);
		assertSame(p, f.getPerfis().get(0));
		
	}
	
}
