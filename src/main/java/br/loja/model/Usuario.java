package br.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "clientes")
public class Usuario extends AbstractPersistable<Long>{

	private static final long serialVersionUID = -7927519821712595526L;
	
	@Column(nullable = true)
	private String nome;
	
	@Column(name = "senha_hash", nullable = true)
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
