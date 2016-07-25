package br.loja.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.loja.DTO.UsuarioDTO;

@ManagedBean(name = "consultaUsuarioBean")
public class ConsultaUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private UsuarioDTO usuario;
	private List<UsuarioDTO> usuarios;

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
