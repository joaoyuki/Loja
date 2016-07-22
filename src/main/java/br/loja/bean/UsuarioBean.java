package br.loja.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.loja.DTO.UsuarioDTO;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	UsuarioDTO usuario;
	
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
	
	public String login(){
		
		
		if ( !validaCampos() ){
			
			return "login.xhtml?facesRedirect=true";
			
		}
		
		return "";
		
	}
	
	public UsuarioDTO getUsuario() {
		return usuario;
	}



	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}



	@PostConstruct
	public void iniciaTela(){
		
		usuario = new UsuarioDTO();
		
	}

}
