package org.hc.teste.unitario;

import org.hc.model.Hospital;
import org.hc.model.Setor;
import org.junit.Test;
import static org.junit.Assert.*;


public class HospitalTeste {
	
	@Test
	public void getInstanceTeste(){
		assertNotNull("Não deve retornar null", Hospital.getInstance());
	}
	
	
	@Test
	public void cadastrarSetorTeste(){
		assertTrue("Deve retornar true", Hospital.getInstance().cadastrarSetor(new Setor()));
		
	}
	
	
	@Test
	public void getNomeTeste(){
		assertSame("Hospital das Clinicas", Hospital.getInstance().getNome());
	}
	

}
