package br.com.florenciof.projetofinal.dto;

public class VolumeAlarmes {
	
	private int idAlarme;
	private long qtde;
	private String nomeAlarme;
		
	public VolumeAlarmes(int idAlarme, long qtde) {
		super();
		this.idAlarme = idAlarme;
		this.qtde = qtde;
	}
	
	public VolumeAlarmes(int idAlarme, String nome, long qtde) {
		super();
		this.idAlarme = idAlarme;
		this.qtde = qtde;
		this.nomeAlarme = nome;
	}
	
	
	public String getNomeAlarme() {
		return nomeAlarme;
	}

	public void setNomeAlarme(String nomeAlarme) {
		this.nomeAlarme = nomeAlarme;
	}

	public void setQtde(long qtde) {
		this.qtde = qtde;
	}

	public long getQtde() {
		return qtde;
	}

	public long getIdAlarme() {
		return idAlarme;
	}
	public void setIdAlarme(int idAlarme) {
		this.idAlarme = idAlarme;
	}

}
