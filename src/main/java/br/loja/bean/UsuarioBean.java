package br.loja.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.loja.DTO.UsuarioDTO;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	UsuarioDTO usuario;
	
	public void login(){
		
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
