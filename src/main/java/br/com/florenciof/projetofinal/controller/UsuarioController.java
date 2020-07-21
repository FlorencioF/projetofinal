package br.com.florenciof.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<Usuario> loginEmail(@RequestBody Usuario usuarioEmailSenha) {
		
		Usuario user = dao.findByEmail(usuarioEmailSenha.getEmail());
		
		if (user==null) {
			return ResponseEntity.notFound().build();
		}
		else {
			if (usuarioEmailSenha.getSenha() == user.getSenha()) {
				return ResponseEntity.ok(user);
			}
			else {
				return ResponseEntity.status(401).build();
			}
		}
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario recuperarPorId(@PathVariable int id) {
		Usuario user = dao.findById(id).orElse(null);
		return (user);
	}
	
}
