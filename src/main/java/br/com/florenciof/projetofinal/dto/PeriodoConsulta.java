package br.com.florenciof.projetofinal.dto;

public class PeriodoConsulta {

	private String inicio;
	private String fim;
		
	public PeriodoConsulta(String inicio, String fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}
}
