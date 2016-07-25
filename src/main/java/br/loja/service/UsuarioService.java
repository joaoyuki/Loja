package br.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.loja.model.Usuario;
import br.loja.reposiorio.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public void salvaUsuario(Usuario usuario){
	
		String hash = new BCryptPasswordEncoder().encode(usuario.getSenha());//BCryptPasswordEncoder é uma classe do Spring security
		repositorio.save(usuario);
		
	}
	
	@Transactional(readOnly = false)
	public void updateSenha(Usuario usuario) {
		
		String hash = new BCryptPasswordEncoder().encode(usuario.getSenha());//BCryptPasswordEncoder é uma classe do Spring security
		
		usuario.setSenha(hash);
		
		repositorio.updateSenha(usuario.getSenha(), usuario.getId());
		
	}
	
	public boolean pesquisaUsuarioPorNome(String nomeUsuario){
		
		Usuario usuario = repositorio.findOneByNome(nomeUsuario);
		if (usuario != null){
			return true;
		}
		
		return false;
	}
	

}
