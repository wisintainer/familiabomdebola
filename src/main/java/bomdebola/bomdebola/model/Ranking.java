package bomdebola.bomdebola.model;

import java.io.Serializable;

public class Ranking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Integer rodada;
	public Integer mes;
	public Integer turno;
	public Integer campeonato;
	public Integer patrimonio;
	public String capitao;

	public Integer getRodada() {
		return rodada;
	}

	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public Integer getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Integer campeonato) {
		this.campeonato = campeonato;
	}

	public Integer getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(Integer patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getCapitao() {
		return capitao;
	}

	public void setCapitao(String capitao) {
		this.capitao = capitao;
	}
}
