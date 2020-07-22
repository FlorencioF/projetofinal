package br.com.florenciof.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.florenciof.projetofinal.model.Alarme;

public interface AlarmeDAO extends CrudRepository<Alarme, Integer> {

}
