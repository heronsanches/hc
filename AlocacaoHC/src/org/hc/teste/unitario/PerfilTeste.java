package org.hc.teste.unitario;

import org.hc.enums.DiaDaSemana;
import org.hc.enums.Turno;
import org.hc.model.Perfil;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerfilTeste {
	
	@Test
	public void PerfilTeste(){
		
		Perfil p = new Perfil();
		assertNotNull("map horarios nao inicializado", p.getHorarios());
		
	}
	
	
	@Test
	public void addHorarioTeste(){
		
		Perfil p = new Perfil();
		p.addHorario(DiaDaSemana.QUI, Turno.MATUTINO);
		assertSame(Turno.MATUTINO, p.getHorarios().get(DiaDaSemana.QUI));
		
	}
	
	
	@Test
	public void getHorariosTeste(){
		
		Perfil p = new Perfil();
		assertEquals(0, p.getHorarios().size(), 7);
		
	}

}
