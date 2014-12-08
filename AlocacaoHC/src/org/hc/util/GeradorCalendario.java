package org.hc.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import org.hc.enums.DiaDaSemana;
import org.hc.enums.Turno;
import org.hc.model.Funcionario;
import org.hc.model.Perfil;
import org.hc.model.Setor;
import org.primefaces.model.DefaultScheduleEvent;

public class GeradorCalendario {


	public static ArrayList<DefaultScheduleEvent> gerarPorSetor(Setor setor) {
		
		ArrayList<DefaultScheduleEvent> result = new ArrayList<DefaultScheduleEvent>();
		
		Calendar hoje = today();
		int primeiroDiaMes = getDayOfYearFirstDayOfMonth(hoje);
		int ultimoDiaMes = getDayOfYearLastDayOfMonth(hoje);
		for (int dia = primeiroDiaMes; dia <= ultimoDiaMes; dia++)
		{
			int funcionariosNoTurnoMatutino = 0;
			int funcionariosNoTurnoVespertino = 0;
			hoje.set(Calendar.DAY_OF_YEAR, dia);
			String nomeFuncionariosNoTurnoMatutino = null;
			String nomeFuncionariosNoTurnoVespertino = null;

			for (Funcionario funcionario : setor.getFuncionarios()) {
				
				//if (funcionariosNoTurnoMatutino == 2 && funcionariosNoTurnoVespertino == 2) break;
				
				Perfil perfil = funcionario.getPerfis().get(0);
				DiaDaSemana diaDaSemana = toDiaDaSemana(hoje.get(Calendar.DAY_OF_WEEK));
				
				Turno turno = null;
				if ((turno = funcionario.listarHorarios(perfil).get(diaDaSemana)) != null)
				{
					Calendar dataInicio = (Calendar)hoje.clone();
					Calendar dataFim = (Calendar)hoje.clone();
					
					dataInicio.setTimeZone(TimeZone.getTimeZone("BRT"));
					dataFim.setTimeZone(TimeZone.getTimeZone("BRT"));
					
					if (turno == Turno.MATUTINO) {
						dataInicio.set(Calendar.HOUR, 8);
						dataInicio.set(Calendar.MINUTE, 0);
						dataInicio.set(Calendar.SECOND, 0);
						dataInicio.set(Calendar.AM_PM, Calendar.AM);
						dataFim.set(Calendar.HOUR, 2);
						dataFim.set(Calendar.MINUTE, 0);
						dataFim.set(Calendar.SECOND, 0);
						dataFim.set(Calendar.AM_PM, Calendar.PM);
						
						funcionariosNoTurnoMatutino++;
						
						if (funcionariosNoTurnoMatutino == 2) {
							funcionariosNoTurnoMatutino = 0;
							DefaultScheduleEvent event = new DefaultScheduleEvent(nomeFuncionariosNoTurnoMatutino + " & " + funcionario.getNome(), dataInicio.getTime(), dataFim.getTime());
							result.add(event);
						}
						else nomeFuncionariosNoTurnoMatutino = funcionario.getNome(); 
					}
					else if (turno == Turno.VESPERTINO) {
						dataInicio.set(Calendar.HOUR, 2);
						dataInicio.set(Calendar.MINUTE, 0);
						dataInicio.set(Calendar.SECOND, 0);
						dataInicio.set(Calendar.AM_PM, Calendar.PM);
						dataFim.set(Calendar.HOUR, 8);
						dataFim.set(Calendar.MINUTE, 0);
						dataFim.set(Calendar.SECOND, 0);
						dataFim.set(Calendar.AM_PM, Calendar.PM);
						
						funcionariosNoTurnoVespertino++;
						
						if (funcionariosNoTurnoVespertino == 2) {
							funcionariosNoTurnoVespertino = 0;
							DefaultScheduleEvent event = new DefaultScheduleEvent(nomeFuncionariosNoTurnoVespertino + " & " + funcionario.getNome(), dataInicio.getTime(), dataFim.getTime());
							result.add(event);
						}
						else nomeFuncionariosNoTurnoVespertino = funcionario.getNome();
					}
				}
			}
		}
		return result;

	}
	
    public static int lastDayOfWeek(Calendar calendar) {  
    	Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.SUNDAY);
		cal.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        int day = cal.get(Calendar.DAY_OF_YEAR);  
        while(cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){  
             cal.set(Calendar.DAY_OF_YEAR, ++day);  
        }  
        return cal.get(Calendar.WEEK_OF_MONTH);
   }
    
    public static int getDayOfYearFirstDayOfMonth(Calendar calendar) {  
    	Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.SUNDAY);
		cal.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        return cal.get(Calendar.DAY_OF_YEAR);  
   }
	
    public static int getDayOfYearLastDayOfMonth(Calendar calendar) {  
    	Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.SUNDAY);
		cal.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.get(Calendar.DAY_OF_YEAR);
   }
    
    private static DiaDaSemana toDiaDaSemana(int dayOfWeek) {
    	switch (dayOfWeek) {
		case Calendar.SUNDAY:
				return DiaDaSemana.DOM;
		case Calendar.MONDAY:
			return DiaDaSemana.SEG;
		case Calendar.TUESDAY:
			return DiaDaSemana.TER;
		case Calendar.WEDNESDAY:
			return DiaDaSemana.QUA;
		case Calendar.THURSDAY:
			return DiaDaSemana.QUI;
		case Calendar.FRIDAY:
			return DiaDaSemana.SEX;
		case Calendar.SATURDAY:
			return DiaDaSemana.SAB;
		default:
			return DiaDaSemana.DOM;
		}
    }
    
    private static int toDayOfWeek(DiaDaSemana diaDaSemana) {
    	switch (diaDaSemana) {
		case DOM:
				return Calendar.SUNDAY;
		case SEG:
			return Calendar.MONDAY;
		case TER:
			return Calendar.TUESDAY;
		case QUA:
			return Calendar.WEDNESDAY;
		case QUI:
			return Calendar.THURSDAY;
		case SEX:
			return Calendar.FRIDAY;
		case SAB:
			return Calendar.SATURDAY;
		default:
			return Calendar.SUNDAY;
		}
    }
    
	private static Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}
}
