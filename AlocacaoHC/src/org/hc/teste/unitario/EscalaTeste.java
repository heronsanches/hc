package org.hc.teste.unitario;

import static org.junit.Assert.*;

import java.util.Date;

import org.hc.model.Escala;
import org.hc.model.Perfil;
import org.hc.model.Setor;
import org.junit.Test;

public class EscalaTeste {
	
	@Test
	public void EscalaTeste(){
		
		Escala e = new Escala();
		assertNotNull("lista de perfis nao foi inicializada", e.getPerfis());
	
	}

	
	@Test
	public void addPerfilTeste(){
		
		Escala e = new Escala();
		Perfil p = new Perfil();
		e.addPerfil(p);
		assertTrue("objeto nao foi inserido", e.getPerfis().contains(p) 
				&& e.getPerfis().size() == 1);
		
	}
	
	
	@Test
	public void getDataTeste(){
		
		Escala e = new Escala();
		Date d = new Date();
		e.setData(d);
		assertEquals(d.getTime(), e.getData().getTime(), 0);
		
	}
	
	
	@Test
	public void setDataTeste(){
		
		getDataTeste();
		
	}
	
	
	@Test
	public void getPerfisTeste(){
		
		Escala e = new Escala();
		Perfil p = new Perfil();
		e.addPerfil(p);
		assertSame(p, e.getPerfis().get(0));
		
	}


	@Test
	public void setSetorTeste() {
		
		Escala e = new Escala();
		Setor s = new Setor();
		e.setSetor(s);
		assertSame(s, e.getSetor());
		
	}
	
	
	@Test
	public void getSetorTeste() {
		
		setSetorTeste();
	
	}


}
