import java.util.Map.Entry;

import org.hc.enums.DiaDaSemana;
import org.hc.enums.Turno;
import org.hc.model.DB;
import org.hc.model.Funcionario;
import org.hc.model.Setor;


public class MainTest {
	
	public static void main(String args[]){
		
		for(Setor s: DB.getDB().getSetores()){
			
			System.out.println("***************************************"+s.getNome()+"***************************************");
			for(Funcionario f: s.getFuncionarios()){
				
				System.out.println("CEP: "+f.getCep());
				System.out.println("CPF: "+f.getCpf());
				System.out.println("EMAIL: "+f.getEmail());
				System.out.println("NOME: "+f.getNome());
				System.out.println("SEXO: "+f.getSexo());
				System.out.println("TELEFONE: "+f.getTelefone());
				System.out.println("*************horários*************");
				
				for(Entry<DiaDaSemana, Turno> h: f.getPerfis().get(0).getHorarios().entrySet()){
					
					System.out.print("Dia: "+h.getKey().getDia());
					
					if(h.getValue() != null)
						System.out.println("\tTurno: "+h.getValue().getTurno());
					else
						System.out.println("\tTurno: "+h.getValue());
						
				}
				
				System.out.println();
			}
			
		}
		
	}

}
