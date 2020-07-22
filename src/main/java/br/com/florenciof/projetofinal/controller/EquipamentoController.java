package br.com.florenciof.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.florenciof.projetofinal.dao.EquipamentoDAO;
import br.com.florenciof.projetofinal.model.Equipamento;

@RestController
public class EquipamentoController {
	
	
	@Autowired
	private EquipamentoDAO dao;
	
	
	@GetMapping("/equipamentos")
	public ArrayList<Equipamento> equipamentos(){
		
		ArrayList<Equipamento> listaEquip = (ArrayList<Equipamento>)dao.findAll();
		return listaEquip;
		
	}

}
