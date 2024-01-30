package bomdebola.bomdebola.util;

public enum ParametrosEnum {

	TOKEN("1905757c9e984bf9b1f688ec928a60b9b544c3937655276366c4835582d704f696b4c3644787037354452327275396b4e48775375384b4b7149357a2d7558577850673362304947494875494f4d33694f624b4868567a63493876434a795a5f726d47477153413d3d3a303a776973696e7461696e65725f323031345f35");

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
