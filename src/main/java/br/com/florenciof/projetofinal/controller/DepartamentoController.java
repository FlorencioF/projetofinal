package br.com.florenciof.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.florenciof.projetofinal.dao.DepartamentoDAO;
import br.com.florenciof.projetofinal.model.Departamento;

@RestController
public class DepartamentoController {

	
	@Autowired
	private DepartamentoDAO dao;
	
	@GetMapping("/departamentos")
	public ArrayList<Departamento> recuperarTodos(){
		
		ArrayList<Departamento> lista;
		
		lista = (ArrayList<Departamento>)dao.findAll();
		return lista;
	}
	
	@GetMapping("/departamentos/{id}")
	public Departamento recuperarPorId(@PathVariable int id) {
		Departamento departamento = dao.findById(id).orElse(null);
		return departamento;
	}
	
}
