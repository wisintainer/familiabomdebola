package bomdebola.bomdebola.model;

import java.io.Serializable;

public class TimeDono implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nome_cartola;
    public String slug;
    public String url_escudo_png;
    public String url_escudo_svg;
    public String foto_perfil;
    public String nome;
    public long facebook_id;
    public int time_id;
    public boolean assinante;
    public boolean lgpd_removido;
    public boolean lgpd_quarentena;
	public String getNome_cartola() {
		return nome_cartola;
	}
	public void setNome_cartola(String nome_cartola) {
		this.nome_cartola = nome_cartola;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getUrl_escudo_png() {
		return url_escudo_png;
	}
	public void setUrl_escudo_png(String url_escudo_png) {
		this.url_escudo_png = url_escudo_png;
	}
	public String getUrl_escudo_svg() {
		return url_escudo_svg;
	}
	public void setUrl_escudo_svg(String url_escudo_svg) {
		this.url_escudo_svg = url_escudo_svg;
	}
	public String getFoto_perfil() {
		return foto_perfil;
	}
	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getFacebook_id() {
		return facebook_id;
	}
	public void setFacebook_id(long facebook_id) {
		this.facebook_id = facebook_id;
	}
	public int getTime_id() {
		return time_id;
	}
	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}
	public boolean isAssinante() {
		return assinante;
	}
	public void setAssinante(boolean assinante) {
		this.assinante = assinante;
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
    
    
}
