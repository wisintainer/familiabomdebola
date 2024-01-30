package bomdebola.bomdebola.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import bomdebola.bomdebola.model.Liga;
import bomdebola.bomdebola.model.Player;
import bomdebola.bomdebola.model.RequestLiga;
import bomdebola.bomdebola.model.Status;
import bomdebola.bomdebola.model.Time;
import bomdebola.bomdebola.service.Api;
import bomdebola.bomdebola.util.PremiacoesEnum;

@Named
@ViewScoped
public class ApiMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Api api;
	private List<Time> times;
	private Liga liga;
	private Status status;
	private String titulo;

	@PostConstruct
	public void init() throws Exception {
		informacoesLiga();
	}

	public void informacoesPlayer() throws Exception {
		api = new Api();
		api.buscarInformacoesPlayer("3164594");
	}

	public void informacoesLiga() throws Exception {
		times = new ArrayList<Time>();
		List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();

		for (Time t : times) {
			t.setPremiacoes(premiacoes);
		}

		api = new Api();
		this.setStatus(api.status());

		// status 3 = mercado em manutenção
		if (this.getStatus().getStatus_mercado() == 3) {
			this.setTitulo("MANUTENÇÃO");
		} else {
			this.setTitulo("Familia Bom de Bola");
			liga = api.buscarInformacoesLiga("familia-bom-de-bola-tj").getLiga();
			times = api.buscarInformacoesLiga("familia-bom-de-bola-tj").getTimes();

			times = api.classificacaogeral(times);
			times = api.campeaoPrimeiroTurno(times, getStatus());
			times = api.campeaoSegundoTurno(times, getStatus());
			times = api.maisRico(times);
			times = api.vencedoresRodadas(times, status);
			//times = api.maiorMitada(times, getStatus());

			times = api.acertaSaldo(times);
		}

	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
