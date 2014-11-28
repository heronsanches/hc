package org.hc.bean;

import java.util.ArrayList;
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
	private Funcionario funcionarioSelecionadoInstancia;
	private String funcionarioSelecionado;
	private String novoNomeFuncionario;
	private String novoCPF;
	private String novoEmail;
	private String novoCEP;
	private String novSexo;
	private String novoTelefone;
	
	
	public String getNovoNomeFuncionario() {
		return novoNomeFuncionario;
	}

	public void setNovoNomeFuncionario(String novoNomeFuncionario) {
		this.novoNomeFuncionario = novoNomeFuncionario;
	}

	public String getNovoCPF() {
		return novoCPF;
	}

	public void setNovoCPF(String novoCPF) {
		this.novoCPF = novoCPF;
	}

	public String getNovoEmail() {
		return novoEmail;
	}

	public void setNovoEmail(String novoEmail) {
		this.novoEmail = novoEmail;
	}

	public String getNovoCEP() {
		return novoCEP;
	}

	public void setNovoCEP(String novoCEP) {
		this.novoCEP = novoCEP;
	}

	public String getNovSexo() {
		return novSexo;
	}

	public void setNovSexo(String novSexo) {
		this.novSexo = novSexo;
	}

	public String getNovoTelefone() {
		return novoTelefone;
	}

	public void setNovoTelefone(String novoTelefone) {
		this.novoTelefone = novoTelefone;
	}

	public String getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(String funcionarioSelecionado) {
				
    	for(Funcionario f: setor.getFuncionarios()){
    		
    		if(f.getNome().contains(funcionarioSelecionado)){
    			
    			this.funcionarioSelecionado = funcionarioSelecionado;
    			funcionarioSelecionadoInstancia = f;
    			System.out.print("flkhghgsdkjhgsdj");
    			
    		}
    		
    	}
	}
	
	

	public Funcionario getFuncionarioSelecionadoInstancia() {
		return funcionarioSelecionadoInstancia;
	}

	public Setor getSetor() {
		return setor;
	}
	
	public void setSetor(Setor setor) {
		this.setor = setor;
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
    
    
    //TODO
    public void showEditarFuncionario(){
    	
    	RequestContext.getCurrentInstance().openDialog("editar_funcionario");
    	
    }
    
    
    //TODO
    public void retornoEditarFuncionario(){
    	
    }
    
    
    /**retorna lista de funcionários correspondente aos caracteres que casam com
     * nome de funcionarios do setor atual */
    public List<String> listaFuncionarios(String caracteres){
    	
    	List<String> funcionarios = new ArrayList<String>();
    	
    	for(Funcionario f: setor.getFuncionarios()){
    		
    		if(f.getNome().contains(caracteres))
    			funcionarios.add(f.getNome());
    		
    	}
    	
    	return funcionarios;
    	
    }
    
    
}
