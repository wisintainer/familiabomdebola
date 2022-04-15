package bomdebola.bomdebola.service;

import com.google.gson.Gson;

import bomdebola.bomdebola.model.Player;
import bomdebola.bomdebola.model.RequestLiga;
import bomdebola.bomdebola.model.Time;
import bomdebola.bomdebola.model.TimePorRodada;
import bomdebola.bomdebola.util.EndpointsEnum;
import bomdebola.bomdebola.util.ParametrosEnum;
import bomdebola.bomdebola.util.PremiacoesEnum;
import bomdebola.bomdebola.util.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import bomdebola.bomdebola.model.Status;

public class Api {
	static String webService = "https://api.cartola.globo.com/";
	static int codigoSucesso = 200;

	public Status status() throws Exception {
		String urlParaChamada = webService + EndpointsEnum.STATUS.getUrl();

		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			conexao.setRequestProperty("User-Agent", "PostmanRuntime/7.26.2");

			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = Utils.converteJsonEmString(resposta);

			Gson gson = new Gson();
			Status status = gson.fromJson(jsonEmString, Status.class);

			return status;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}

	public Player buscarInformacoesPlayer(String slug_player) throws Exception {
		String urlParaChamada = webService + EndpointsEnum.INFORMACOES_PLAYER.getUrl() + slug_player;

		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			conexao.setRequestProperty("User-Agent", "PostmanRuntime/7.26.2");

			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = Utils.converteJsonEmString(resposta);

			Gson gson = new Gson();
			Player player = gson.fromJson(jsonEmString, Player.class);

			System.out.println(player.getTime().getNome());

			return player;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}

	public RequestLiga buscarInformacoesLiga(String slug_liga) throws Exception {
		String urlParaChamada = webService + EndpointsEnum.INFORMACOES_LIGA.getUrl() + slug_liga;

		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			conexao.setRequestProperty("User-Agent", "PostmanRuntime/7.26.2");
			conexao.setRequestProperty("X-GLB-Token",
					"1635b5b4c84a278b8efc41b9e51952603427a64645565526c6341532d377856587177506c4274315f4e6f684156785a5569756d616d55386e56474b4f4c4256442d79784b774f4a37555633614a582d564c303934727450346278774c6266694d7367437173413d3d3a303a776973696e7461696e65725f323031345f35");

			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = Utils.converteJsonEmString(resposta);

			Gson gson = new Gson();
			RequestLiga liga = gson.fromJson(jsonEmString, RequestLiga.class);

			return liga;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}

	public List<Time> campeaoPrimeiroTurno(List<Time> times, Status status) {
		for (Time time : times) {
			if (status.getRodada_atual() <= 19) {
				if (time.getRanking().getTurno() == 1) {
					time.getPremiacoes().add(PremiacoesEnum.CAMPEAO_PRIMEIRO_TURNO);
				}
			}
		}

		return times;
	}

	public List<Time> campeaoSegundoTurno(List<Time> times, Status status) {
		for (Time time : times) {
			if (status.getRodada_atual() >= 20) {
				if (time.getRanking().getTurno() == 1) {
					time.getPremiacoes().add(PremiacoesEnum.CAMPEAO_SEGUNDO_TURNO);
				}
			}
		}
		return times;
	}

	public List<Time> maisRico(List<Time> times) {
		Time maisRico = new Time();
		maisRico.setPatrimonio(0.0);

		for (Time time : times) {
			if (time.getRanking().getPatrimonio() == 1) {
				time.getPremiacoes().add(PremiacoesEnum.MAIS_RICO);
			}
		}

		return times;
	}

	public Time lanterna(List<Time> times) {
		Time lanterna = new Time();
		lanterna.getPontos().setCampeonato(99999999999.99);

		for (Time time : times) {
			if (time.getPontos().getCampeonato() < lanterna.getPontos().getCampeonato()) {
				lanterna = time;
			}
		}
		return lanterna;
	}

	public List<Time> classificacaogeral(List<Time> times) {
		for (Time time : times) {
			if (time.ranking.getCampeonato() == 1) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.PRIMEIRO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 2) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.SEGUNDO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 3) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.TERCEIRO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 4) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.QUARTO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 5) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.QUINTO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 6) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.SEXTO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 7) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.SETIMO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 8) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.OITAVO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 9) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.NONO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() == 10) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				premiacoes.add(PremiacoesEnum.DECIMO_COLOCADO);
				time.setPremiacoes(premiacoes);
			}

			if (time.ranking.getCampeonato() > 10) {
				List<PremiacoesEnum> premiacoes = new ArrayList<PremiacoesEnum>();
				time.setPremiacoes(premiacoes);
				time.setSaldo(0.0);
			}
		}
		return times;
	}

	public List<Time> acertaSaldo(List<Time> times) {
		for (Time time : times) {
			if (time.getPremiacoes() != null) {
				time.setSaldo(0.0);
				for (PremiacoesEnum p : time.getPremiacoes()) {
					time.setSaldo(time.getSaldo() + p.getValor());
				}
			}

		}
		return times;
	}

	public Double pontosPorRodada(Time time, int rodada) throws Exception {
		String urlParaChamada = webService + EndpointsEnum.INFORMACOES_PLAYER.getUrl() + time.getTime_id() + "/"
				+ rodada;
		TimePorRodada tpr = new TimePorRodada();
		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			conexao.setRequestProperty("User-Agent", "PostmanRuntime/7.26.2");
			conexao.setRequestProperty("X-GLB-Token", ParametrosEnum.TOKEN.getValor());

			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = Utils.converteJsonEmString(resposta);

			Gson gson = new Gson();
			TimePorRodada timeVindo = gson.fromJson(jsonEmString, TimePorRodada.class);

			Time timeRetorno = new Time();
			timeRetorno = timeVindo.getTime();
			timeRetorno.setPontosPorRodada(timeVindo.getPontos());

			return timeRetorno.getPontosPorRodada();
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}

	public List<Time> vencedoresRodadas(List<Time> times) throws Exception {
		Time vencedorRodada1 = new Time();
		vencedorRodada1.setPontosPorRodada(0.0);

		for (Time time : times) {
			Time timeParaComparar = new Time();
			timeParaComparar.setPontosPorRodada(pontosPorRodada(time, 1));
			if (timeParaComparar.getPontosPorRodada() > vencedorRodada1.getPontosPorRodada()) {
				vencedorRodada1 = time;
				vencedorRodada1.setPontosPorRodada(timeParaComparar.getPontosPorRodada());
			}
		}

		for (Time time : times) {
			if (time.getSlug().equals(vencedorRodada1.getSlug())) {
				time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_1);
			}
		}
		

		return times;
	}

}