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
			conexao.setRequestProperty("X-GLB-Token", ParametrosEnum.TOKEN.getValor());

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

	public List<Time> vencedoresRodadas(List<Time> times, Status status) throws Exception {
//-----------------------------------------------------------------------------------------------------
		Time vencedorRodada1 = new Time();
		vencedorRodada1.setPontosPorRodada(0.0);

		for (int i = 1; i <= 38; i++) {
			if (status.getRodada_atual() > i) {
				Time vencedorRodada = new Time();
				vencedorRodada.setPontosPorRodada(0.0);

				for (Time time : times) {
					Time timeParaComparar = new Time();
					timeParaComparar.setPontosPorRodada(pontosPorRodada(time, i));
					if (timeParaComparar.getPontosPorRodada() > vencedorRodada.getPontosPorRodada()) {
						vencedorRodada = time;
						vencedorRodada.setPontosPorRodada(timeParaComparar.getPontosPorRodada());
					}
				}
				for (Time time : times) {
					if (time.getSlug().equals(vencedorRodada.getSlug())) {
						if (i == 1) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_1);
						}
						if (i == 2) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_2);
						}
						if (i == 3) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_3);
						}
						if (i == 4) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_4);
						}
						if (i == 5) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_5);
						}
						if (i == 6) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_6);
						}
						if (i == 7) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_7);
						}
						if (i == 8) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_8);
						}
						if (i == 9) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_9);
						}
						if (i == 10) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_10);
						}
						if (i == 11) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_11);
						}
						if (i == 12) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_12);
						}
						if (i == 13) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_13);
						}
						if (i == 14) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_14);
						}
						if (i == 15) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_15);
						}
						if (i == 16) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_16);
						}
						if (i == 17) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_17);
						}
						if (i == 18) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_18);
						}
						if (i == 19) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_19);
						}
						if (i == 20) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_20);
						}
						if (i == 21) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_21);
						}
						if (i == 22) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_22);
						}
						if (i == 23) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_23);
						}
						if (i == 24) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_24);
						}
						if (i == 25) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_25);
						}
						if (i == 26) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_26);
						}
						if (i == 27) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_27);
						}
						if (i == 28) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_28);
						}
						if (i == 29) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_29);
						}
						if (i == 30) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_30);
						}
						if (i == 31) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_31);
						}
						if (i == 32) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_32);
						}
						if (i == 33) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_33);
						}
						if (i == 34) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_34);
						}
						if (i == 35) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_35);
						}
						if (i == 36) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_36);
						}
						if (i == 37) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_37);
						}
						if (i == 38) {
							time.getPremiacoes().add(PremiacoesEnum.VENCEDOR_RODADA_38);
						}

					}
				}
			}
		}

		return times;
	}

	public List<Time> maiorMitada(List<Time> times, Status status) throws Exception {
		Time timeMaiorMitada = new Time();
		timeMaiorMitada.setPontosPorRodada(0.0);
		for (int i = 1; i <= status.getRodada_atual(); i++) {
			for (Time time : times) {
				if (pontosPorRodada(time, i) > timeMaiorMitada.getPontosPorRodada()) {
					timeMaiorMitada = time;
				}
			}
		}

		for (Time time : times) {
			if (time.getSlug().equals(timeMaiorMitada.getSlug())) {
				time.getPremiacoes().add(PremiacoesEnum.MAIOR_MITADA);
			}
		}
		return times;
	}

}