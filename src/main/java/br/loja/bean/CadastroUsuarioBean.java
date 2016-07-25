package br.loja.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.loja.DTO.UsuarioDTO;


@ManagedBean(name = "cadastroUsuarioBean")
public class CadastroUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UsuarioDTO usuario;

	@PostConstruct
	public void iniciaTela(){
		
		setUsuario(new UsuarioDTO());
		
	}
	
	public boolean validaCampos(){
		
		if (usuario.getNome() == null || usuario.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nome precisa ser preenchido."));
			return true;
		}
		
		if (usuario.getSenha() == null || usuario.getSenha().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Senha precisa ser preenchida."));
			return true;
		}
		
		return false;
	}
	
	public boolean verficaNomeExistente(){
		
		
		
		return false;
	}
	
	public String cadastraUsuario(){
		
		if ( !validaCampos() ){
			
		}
		
		return "";
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	

}
