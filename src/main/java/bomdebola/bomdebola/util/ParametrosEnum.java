package bomdebola.bomdebola.util;

public enum ParametrosEnum {

	TOKEN("17ac767d101f0674c03acfe932b4970ad4a726736686b7738644978764c374956744c71724f455079345f66362d336764727356484f74326f4f7269635565345439493959584732766f764e662d50586758754a582d343068654b706b784548336f7273744f773d3d3a303a776973696e7461696e65725f323031345f35");

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
