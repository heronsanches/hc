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
		
		for (Funcionario funcionario : setor.getFuncionarios()) {
			Perfil perfil = funcionario.getPerfis().get(0);
			int ultimoDiaMes = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
			for (int dia = 1; dia <= ultimoDiaMes; dia++)
			{
				for (DiaDaSemana diaDaSemana : funcionario.listarHorarios(perfil).keySet()) {
					Turno turno = funcionario.listarHorarios(perfil).get(diaDaSemana);

					if (turno != null)
					{
						Calendar dataInicio = (Calendar)today().clone();
						Calendar dataFim = (Calendar)today().clone();
						
						dataInicio.set(Calendar.DAY_OF_MONTH, dia);
						dataFim.set(Calendar.DAY_OF_MONTH, dia);
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
						}
						
						int primeiroSabado = lastDayOfWeek(dataInicio);
						if (dia <= primeiroSabado)
						{
							dataInicio.set(Calendar.WEEK_OF_MONTH, 1);
							dataFim.set(Calendar.WEEK_OF_MONTH, 1);
						}
						else if (dia <= primeiroSabado + 7)
						{
							dataInicio.set(Calendar.WEEK_OF_MONTH, 2);
							dataFim.set(Calendar.WEEK_OF_MONTH, 2);
						}
						else if (dia <= primeiroSabado + 14)
						{
							dataInicio.set(Calendar.WEEK_OF_MONTH, 3);
							dataFim.set(Calendar.WEEK_OF_MONTH, 3);
						}
						else if (dia <= primeiroSabado + 21)
						{
							dataInicio.set(Calendar.WEEK_OF_MONTH, 4);
							dataFim.set(Calendar.WEEK_OF_MONTH, 4);
						}
						else //if (dia <= ultimoDiaMes)
						{
							dataInicio.set(Calendar.WEEK_OF_MONTH, 5);
							dataFim.set(Calendar.WEEK_OF_MONTH, 5);
						}
						
						switch (diaDaSemana) {
						case DOM:
							dataInicio.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
							dataFim.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
							break;
						case SEG:
								dataInicio.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
								dataFim.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
								break;
						case TER:
								dataInicio.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
								dataFim.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
								break;
						case QUA:
								dataInicio.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
								dataFim.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
								break;
						case QUI:
								dataInicio.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
								dataFim.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
								break;
						case SEX:
								dataInicio.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
								dataFim.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
								break;
						case SAB:
								dataInicio.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
								dataFim.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
								break;
						default:
							break;
						}
						DefaultScheduleEvent event = new DefaultScheduleEvent(funcionario.getNome(), dataInicio.getTime(), dataFim.getTime());
						result.add(event);
					}
				}
			}
		}
		return result;

	}
	
    public static int lastDayOfWeek(Calendar calendar){  
    	Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.SUNDAY);
		cal.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        int day = cal.get(Calendar.DAY_OF_YEAR);  
        while(cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){  
             cal.set(Calendar.DAY_OF_YEAR, ++day);  
        }  
        return cal.get(Calendar.WEEK_OF_MONTH);
   }
	
	private static Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}
}
