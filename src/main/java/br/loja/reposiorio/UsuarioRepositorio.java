package br.loja.reposiorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.loja.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	@Modifying
	@Query("update Usuario u set u.senha = ?1 where u.id = ?2")
	void updateSenha(String senha, Long id);

	Usuario findOneByNome(String nomeUsuario);
	
}
