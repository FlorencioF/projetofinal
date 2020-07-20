package br.com.florenciof.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="email", length=100, unique=true)
	private String email;
	
	@Column(name="racf", length=7)
	private String racf;
	
	@Column(name="senha", length=50)
	private String senha;
	
	@Column(name="foto", length=250)
	private String linkFoto;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}


	
	
}
