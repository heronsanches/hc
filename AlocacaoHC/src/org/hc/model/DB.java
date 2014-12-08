package org.hc.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hc.enums.DiaDaSemana;
import org.hc.enums.Turno;
/** Inicializa DB para a aplicação. */

public class DB {

	private List<Setor> setores;
	
	private final int QTDE_SETORES = 3;
	private final int QTDE_FUNCIONARIOS_SETOR = 24;
	private static int CONT_FUNCIONARIOS_TOTAL = 0;
	
	private final String NOME_SETOR = "Setor ";
	private final String NOME_FUNCIONARIO = "Funcionario ";
	private final String CPF_FUNCIONARIO = "CPF";
	private final String CEP_FUNCIONARIO = "CEP";
	private final String EMAIL_FUNCIONARIO = "Email";
	private final String TELEFONE_FUNCIONARIO = "Telefone";
	
	private final static DB instance= new DB();
	
	
	private DB(){
		
		inicializarSetor();
		
	}
	
	
	public static DB getDB(){
		return instance;
	}
	
	public List<Setor> getSetores() {
		return setores;
	}
	
	/*public void updateFuncionario(String ns, String nf, Funcionario nnf){

		Iterator<Setor> is = setores.iterator();
		Funcionario f;
		Setor s;
		while(is.hasNext()){
			if((s = is.next()).getNome().equals(ns)){
				Iterator<Funcionario> iff = s.getFuncionarios().iterator();
				while(iff.hasNext()){
					if(iff.next().getNome().equals(nf)){
						iff.remove();
						f = new Funcionario();
						f.setCep(nnf.getCep());
						f.setCpf(nnf.getCpf());
						f.setEmail(nnf.getEmail());
						f.setNome(nnf.getNome());
						f.setTelefone(nnf.getTelefone());
						s.cadFuncionario(f);
					}
				}
			}
		}
		
		
	}*/

	/**Inicializa DB com {@linkplain DB#QTDE_SETORES} e cada setor possuindo
	 * {@linkplain DB#QTDE_FUNCIONARIOS_SETOR}. Cada funcionário inicializa
	 * com um perfil que possui apenas um horário como desejado(marcado-disponivel)*/
	private void inicializarSetor(){
		Setor s;
		Funcionario f;
		Perfil p;
		setores = new ArrayList<Setor>();

		for(int ns=1; ns<=QTDE_SETORES; ns++){
			
			s = new Setor();
			
			for(int nf=1; nf<=QTDE_FUNCIONARIOS_SETOR; nf++){
				
				f = new Funcionario();
				p = new Perfil();
				
				f.setCep(CEP_FUNCIONARIO+CONT_FUNCIONARIOS_TOTAL);
				f.setCpf(CPF_FUNCIONARIO+CONT_FUNCIONARIOS_TOTAL);
				f.setEmail(EMAIL_FUNCIONARIO+CONT_FUNCIONARIOS_TOTAL);
				
				if(nf%2 != 0)
					f.setSexo('m');
				else
					f.setSexo('f');
				
				f.setTelefone(TELEFONE_FUNCIONARIO+CONT_FUNCIONARIOS_TOTAL);
				f.setNome(NOME_FUNCIONARIO+CONT_FUNCIONARIOS_TOTAL);
				//cadastra somente um horário para um dia deste funcionário, os outros dias ficam sem horario
				p.addHorario(DiaDaSemana.values()[nf%6], Turno.values()[nf%2]);
				p.addHorario(DiaDaSemana.values()[(nf+1)%6], Turno.values()[(nf)%2]);
				f.addPerfil(p);
				s.cadFuncionario(f);

				CONT_FUNCIONARIOS_TOTAL++;
				
			}
			
			s.setResponsavel(null);
			s.setNome(NOME_SETOR+ns);
			setores.add(s);
		
		}
		
	}
}
