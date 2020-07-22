package br.com.florenciof.projetofinal.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.florenciof.projetofinal.dto.VolumeAlarmes;
import br.com.florenciof.projetofinal.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer>{
	
	public ArrayList<Evento> findByOrderByData();
	
	public ArrayList<Evento> findByDataBetween(Date inicio, Date fim);
		
	@Query("SELECT new br.com.florenciof.projetofinal.dto.VolumeAlarmes(ev.alarme.id, ev.alarme.nome, count(ev.alarme.id)) FROM Evento ev GROUP BY ev.alarme.id")
	public ArrayList<VolumeAlarmes> getAllWithName();

}
