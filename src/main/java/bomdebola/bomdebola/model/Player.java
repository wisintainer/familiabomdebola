package bomdebola.bomdebola.model;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Time time;
	private String mensagem;
	private Integer premiacao;

	private String rodada_atual;

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getRodada_atual() {
		return rodada_atual;
	}

	public void setRodada_atual(String rodada_atual) {
		this.rodada_atual = rodada_atual;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getPremiacao() {
		return premiacao;
	}

	public void setPremiacao(Integer premiacao) {
		this.premiacao = premiacao;
	}

}
