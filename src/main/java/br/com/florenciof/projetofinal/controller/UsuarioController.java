package br.com.florenciof.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.florenciof.projetofinal.dao.UsuarioDAO;
import br.com.florenciof.projetofinal.model.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperarTodos(){
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario userEmailSenha) {
		
		Usuario user = dao.findByEmailAndSenha(userEmailSenha.getEmail(), userEmailSenha.getSenha());
		
		if (user!=null) {
			return ResponseEntity.ok(user);
		}
		else
			return ResponseEntity.status(403).build();
		
	}
	
}
