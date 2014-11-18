package org.hc.bean;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hc.model.DB;
import org.hc.model.Funcionario;
import org.hc.model.Setor;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


public class SetoresView {
	
	private String novoNome;
	private Setor setor;
	
	
	public Setor getSetor() {
		return setor;
	}
	
	public List<Funcionario> getFuncionarios(){
		return setor.getFuncionarios();
	}

	public String getNovoNome(){
		return novoNome;
	}
	
	public void setNovoNome(String nome){
		novoNome = nome;
	}
	

	public List<Setor> getSetores(){
		 return DB.getDB().getSetores();
	}
	
	
	public void editarSetor(Setor antigoSetor){
		
		this.setor = antigoSetor;
		RequestContext.getCurrentInstance().openDialog("editar_setor");
		
	}
	
    
    
	public void fecharDialogEditarSetor(String novoNome) {
        RequestContext.getCurrentInstance().closeDialog(novoNome);
    }
    
    
    public void retornoEditarSetor(SelectEvent event) {
    	
    	String novo_nome = (String) event.getObject();
    	setor.setNome(novo_nome);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
    public void showFuncionarios(Setor setor){
    	
    	this.setor = setor;
    	RequestContext.getCurrentInstance().openDialog("show_funcionarios");
    	
    }
    
}
