package org.hc.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hc.model.DB;
import org.hc.model.Setor;
import org.hc.util.GeradorCalendario;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CalendarioView implements Serializable {

	private ScheduleModel eventModel;
	private String setor;
	private Map<String, String> setores;

	private ScheduleEvent event = new DefaultScheduleEvent();

	public void onSetorChange() {
		eventModel = new DefaultScheduleModel();
		if (setor != null && !setor.equals("")) {
			Setor setorObj = getSetoresBD().get(Integer.parseInt(setor));
			for (DefaultScheduleEvent event : GeradorCalendario.gerarPorSetor(setorObj)) {
				eventModel.addEvent(event);
			}
		}
	}

	public void displayLocation() {
		FacesMessage messages;
		if (setor != null)
			messages = new FacesMessage("Setor: " + setor);
		else
			messages = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid",
					"Setor não selecionado.");

		FacesContext.getCurrentInstance().addMessage(null, messages);
	}

	public List<Setor> getSetoresBD(){
		return DB.getDB().getSetores();
	}

	@PostConstruct
	public void init() {
		setores  = new HashMap<String, String>();
		int i = 0;
		for (Setor s : getSetoresBD()) {
			setores.put(s.getNome(), "" + i);
			i++;
		}
	}

	public Date getRandomDate(Date base) {
		Calendar date = Calendar.getInstance();
		date.setTime(base);
		date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1); // set random
		// day of
		// month

		return date.getTime();
	}

	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY,
				calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar.getTime();
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String value) {
		setor = value;
	}

	public Map<String, String> getSetores() {
		return setores;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);

		event = new DefaultScheduleEvent();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(),
				(Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event moved", "Day delta:" + event.getDayDelta()
				+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event resized", "Day delta:" + event.getDayDelta()
				+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}