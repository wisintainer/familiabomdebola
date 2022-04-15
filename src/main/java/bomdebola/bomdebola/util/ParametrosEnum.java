package bomdebola.bomdebola.util;

public enum ParametrosEnum {

	TOKEN("Campeão Geral");

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	private ParametrosEnum(String valor) {
		this.valor = valor;
	}

}
