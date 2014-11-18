package org.hc.teste.unitario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses(value={SetorTeste.class, HospitalTeste.class, PerfilTeste.class, FuncionarioTeste.class,
		EscalaTeste.class})
public class SuiteTeste {

}
