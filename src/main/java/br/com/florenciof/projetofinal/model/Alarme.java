package br.com.florenciof.projetofinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn_alarme")
public class Alarme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_alarme")
	private int id;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="descricao", length=200)
	private String descrico;
	
	@JsonIgnoreProperties("alarme")
	@OneToMany(mappedBy="alarme", cascade=CascadeType.ALL)
	private List<Evento> listaEventos;

	
	
	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrico() {
		return descrico;
	}

	public void setDescrico(String descrico) {
		this.descrico = descrico;
	}

	
	
}
