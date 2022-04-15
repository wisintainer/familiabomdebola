package bomdebola.bomdebola.model;

import java.util.List;

import bomdebola.bomdebola.util.PremiacoesEnum;

public class Time {
	public int temporada_inicial;
	public String cor_fundo_escudo;
	public String cor_camisa;
	public String cor_borda_escudo;
	public String foto_perfil;
	public String nome_cartola;
	public String globo_id;
	public String nome;
	public String url_escudo_svg;
	public String url_escudo_png;
	public String url_camisa_svg;
	public String url_camisa_png;
	public String slug;
	public String cor_secundaria_estampa_escudo;
	public Object sorteio_pro_num;
	public String cor_primaria_estampa_camisa;
	public String cor_secundaria_estampa_camisa;
	public String cor_primaria_estampa_escudo;
	public Object rodada_time_id;
	public long facebook_id;
	public int tipo_escudo;
	public int time_id;
	public int tipo_adorno;
	public int esquema_id;
	public int tipo_estampa_camisa;
	public int tipo_estampa_escudo;
	public int patrocinador1_id;
	public int clube_id;
	public int tipo_camisa;
	public int patrocinador2_id;
	public boolean assinante;
	public boolean simplificado;
	public boolean cadastro_completo;
	public boolean lgpd_removido;
	public boolean lgpd_quarentena;
	private Double patrimonio;

	public Ranking ranking;
	public Pontos pontos;

	private Double saldo;

	private List<PremiacoesEnum> premiacoes;

	private Double rodada_atual;

	private Double pontosPorRodada;

	public int getTemporada_inicial() {
		return temporada_inicial;
	}

	public void setTemporada_inicial(int temporada_inicial) {
		this.temporada_inicial = temporada_inicial;
	}

	public String getCor_fundo_escudo() {
		return cor_fundo_escudo;
	}

	public void setCor_fundo_escudo(String cor_fundo_escudo) {
		this.cor_fundo_escudo = cor_fundo_escudo;
	}

	public String getCor_camisa() {
		return cor_camisa;
	}

	public void setCor_camisa(String cor_camisa) {
		this.cor_camisa = cor_camisa;
	}

	public String getCor_borda_escudo() {
		return cor_borda_escudo;
	}

	public void setCor_borda_escudo(String cor_borda_escudo) {
		this.cor_borda_escudo = cor_borda_escudo;
	}

	public String getFoto_perfil() {
		return foto_perfil;
	}

	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}

	public String getNome_cartola() {
		return nome_cartola;
	}

	public void setNome_cartola(String nome_cartola) {
		this.nome_cartola = nome_cartola;
	}

	public String getGlobo_id() {
		return globo_id;
	}

	public void setGlobo_id(String globo_id) {
		this.globo_id = globo_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl_escudo_svg() {
		return url_escudo_svg;
	}

	public void setUrl_escudo_svg(String url_escudo_svg) {
		this.url_escudo_svg = url_escudo_svg;
	}

	public String getUrl_escudo_png() {
		return url_escudo_png;
	}

	public void setUrl_escudo_png(String url_escudo_png) {
		this.url_escudo_png = url_escudo_png;
	}

	public String getUrl_camisa_svg() {
		return url_camisa_svg;
	}

	public void setUrl_camisa_svg(String url_camisa_svg) {
		this.url_camisa_svg = url_camisa_svg;
	}

	public String getUrl_camisa_png() {
		return url_camisa_png;
	}

	public void setUrl_camisa_png(String url_camisa_png) {
		this.url_camisa_png = url_camisa_png;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getCor_secundaria_estampa_escudo() {
		return cor_secundaria_estampa_escudo;
	}

	public void setCor_secundaria_estampa_escudo(String cor_secundaria_estampa_escudo) {
		this.cor_secundaria_estampa_escudo = cor_secundaria_estampa_escudo;
	}

	public Object getSorteio_pro_num() {
		return sorteio_pro_num;
	}

	public void setSorteio_pro_num(Object sorteio_pro_num) {
		this.sorteio_pro_num = sorteio_pro_num;
	}

	public String getCor_primaria_estampa_camisa() {
		return cor_primaria_estampa_camisa;
	}

	public void setCor_primaria_estampa_camisa(String cor_primaria_estampa_camisa) {
		this.cor_primaria_estampa_camisa = cor_primaria_estampa_camisa;
	}

	public String getCor_secundaria_estampa_camisa() {
		return cor_secundaria_estampa_camisa;
	}

	public void setCor_secundaria_estampa_camisa(String cor_secundaria_estampa_camisa) {
		this.cor_secundaria_estampa_camisa = cor_secundaria_estampa_camisa;
	}

	public String getCor_primaria_estampa_escudo() {
		return cor_primaria_estampa_escudo;
	}

	public void setCor_primaria_estampa_escudo(String cor_primaria_estampa_escudo) {
		this.cor_primaria_estampa_escudo = cor_primaria_estampa_escudo;
	}

	public Object getRodada_time_id() {
		return rodada_time_id;
	}

	public void setRodada_time_id(Object rodada_time_id) {
		this.rodada_time_id = rodada_time_id;
	}

	public long getFacebook_id() {
		return facebook_id;
	}

	public void setFacebook_id(long facebook_id) {
		this.facebook_id = facebook_id;
	}

	public int getTipo_escudo() {
		return tipo_escudo;
	}

	public void setTipo_escudo(int tipo_escudo) {
		this.tipo_escudo = tipo_escudo;
	}

	public int getTime_id() {
		return time_id;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public int getTipo_adorno() {
		return tipo_adorno;
	}

	public void setTipo_adorno(int tipo_adorno) {
		this.tipo_adorno = tipo_adorno;
	}

	public int getEsquema_id() {
		return esquema_id;
	}

	public void setEsquema_id(int esquema_id) {
		this.esquema_id = esquema_id;
	}

	public int getTipo_estampa_camisa() {
		return tipo_estampa_camisa;
	}

	public void setTipo_estampa_camisa(int tipo_estampa_camisa) {
		this.tipo_estampa_camisa = tipo_estampa_camisa;
	}

	public int getTipo_estampa_escudo() {
		return tipo_estampa_escudo;
	}

	public void setTipo_estampa_escudo(int tipo_estampa_escudo) {
		this.tipo_estampa_escudo = tipo_estampa_escudo;
	}

	public int getPatrocinador1_id() {
		return patrocinador1_id;
	}

	public void setPatrocinador1_id(int patrocinador1_id) {
		this.patrocinador1_id = patrocinador1_id;
	}

	public int getClube_id() {
		return clube_id;
	}

	public void setClube_id(int clube_id) {
		this.clube_id = clube_id;
	}

	public int getTipo_camisa() {
		return tipo_camisa;
	}

	public void setTipo_camisa(int tipo_camisa) {
		this.tipo_camisa = tipo_camisa;
	}

	public int getPatrocinador2_id() {
		return patrocinador2_id;
	}

	public void setPatrocinador2_id(int patrocinador2_id) {
		this.patrocinador2_id = patrocinador2_id;
	}

	public boolean isAssinante() {
		return assinante;
	}

	public void setAssinante(boolean assinante) {
		this.assinante = assinante;
	}

	public boolean isSimplificado() {
		return simplificado;
	}

	public void setSimplificado(boolean simplificado) {
		this.simplificado = simplificado;
	}

	public boolean isCadastro_completo() {
		return cadastro_completo;
	}

	public void setCadastro_completo(boolean cadastro_completo) {
		this.cadastro_completo = cadastro_completo;
	}

	public boolean isLgpd_removido() {
		return lgpd_removido;
	}

	public void setLgpd_removido(boolean lgpd_removido) {
		this.lgpd_removido = lgpd_removido;
	}

	public boolean isLgpd_quarentena() {
		return lgpd_quarentena;
	}

	public void setLgpd_quarentena(boolean lgpd_quarentena) {
		this.lgpd_quarentena = lgpd_quarentena;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public Pontos getPontos() {
		return pontos;
	}

	public void setPontos(Pontos pontos) {
		this.pontos = pontos;
	}

	public Double getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(Double patrimonio) {
		this.patrimonio = patrimonio;
	}

	public List<PremiacoesEnum> getPremiacoes() {
		return premiacoes;
	}

	public void setPremiacoes(List<PremiacoesEnum> premiacoes) {
		this.premiacoes = premiacoes;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getRodada_atual() {
		return rodada_atual;
	}

	public void setRodada_atual(Double rodada_atual) {
		this.rodada_atual = rodada_atual;
	}

	public Double getPontosPorRodada() {
		return pontosPorRodada;
	}

	public void setPontosPorRodada(Double pontosPorRodada) {
		this.pontosPorRodada = pontosPorRodada;
	}

}
