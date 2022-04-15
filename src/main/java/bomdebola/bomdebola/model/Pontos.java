package bomdebola.bomdebola.model;

import java.io.Serializable;

public class Pontos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Double rodada;
	public Double mes;
	public Double turno;
	public Double campeonato;
	public int capitao;

	public Double getRodada() {
		return rodada;
	}

	public void setRodada(Double rodada) {
		this.rodada = rodada;
	}

	public Double getMes() {
		return mes;
	}

	public void setMes(Double mes) {
		this.mes = mes;
	}

	public Double getTurno() {
		return turno;
	}

	public void setTurno(Double turno) {
		this.turno = turno;
	}

	public Double getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Double campeonato) {
		this.campeonato = campeonato;
	}

	public int getCapitao() {
		return capitao;
	}

	public void setCapitao(int capitao) {
		this.capitao = capitao;
	}

}
