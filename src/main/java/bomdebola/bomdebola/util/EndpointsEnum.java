package bomdebola.bomdebola.util;

public enum EndpointsEnum {

	INFORMACOES_PLAYER("time/id/"),
	STATUS("mercado/status"),
	INFORMACOES_LIGA("auth/liga/");

	EndpointsEnum(String url) {
		this.url = url;
	}

	private String url;

	public String getUrl() {
		return url;
	}

}
