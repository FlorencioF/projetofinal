package br.com.florenciof.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.florenciof.projetofinal.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByEmailAndSenha(String email, String senha);
	
	public Usuario findByEmail(String email);	
	
	public Usuario findByEmailOrRacf(String email, String racf);

}
