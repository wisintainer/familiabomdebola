package bomdebola.bomdebola.util;

public enum PremiacoesEnum {

	PRIMEIRO_COLOCADO(1300, "Primeiro Colocado Geral"),
	SEGUNDO_COLOCADO(800,"Segundo Colocado Geral"),
	TERCEIRO_COLOCADO(500,"Terceiro Colocado Geral"),
	QUARTO_COLOCADO(350,"Quarto Colocado Geral"),
	QUINTO_COLOCADO(300,"Quinto Colocado Geral"),
	SEXTO_COLOCADO(250,"Sexto Colocado Geral"),
	SETIMO_COLOCADO(200,"Sétimo Colocado Geral"),
	OITAVO_COLOCADO(150,"Oitavo Colocado Geral"),
	NONO_COLOCADO(100,"Nono Colocado Geral"),
	DECIMO_COLOCADO(50,"Décimo Colocado Geral"),
	CAMPEAO_PRIMEIRO_TURNO(100,"Campeão do Primeiro Turno"),
	CAMPEAO_SEGUNDO_TURNO(100,"Campeão do Segundo Turno"),
	MAIOR_MITADA(200,"Maior Mitada"),
	MAIS_RICO(200,"Mais Rico"),
	CAMPEAO_DA_RODADA(10,"Campeão da Rodada"),
	
	VENCEDOR_RODADA_1(10,"Vencedor da rodada 1"),
	VENCEDOR_RODADA_2(10,"Vencedor da rodada 2"),
	VENCEDOR_RODADA_3(10,"Vencedor da rodada 3"),
	VENCEDOR_RODADA_4(10,"Vencedor da rodada 4"),
	VENCEDOR_RODADA_5(10,"Vencedor da rodada 5"),
	VENCEDOR_RODADA_6(10,"Vencedor da rodada 6"),
	VENCEDOR_RODADA_7(10,"Vencedor da rodada 7"),
	VENCEDOR_RODADA_8(10,"Vencedor da rodada 8"),
	VENCEDOR_RODADA_9(10,"Vencedor da rodada 9"),
	VENCEDOR_RODADA_10(10,"Vencedor da rodada 10"),
	VENCEDOR_RODADA_11(10,"Vencedor da rodada 11"),
	VENCEDOR_RODADA_12(10,"Vencedor da rodada 12"),
	VENCEDOR_RODADA_13(10,"Vencedor da rodada 13"),
	VENCEDOR_RODADA_14(10,"Vencedor da rodada 14"),
	VENCEDOR_RODADA_15(10,"Vencedor da rodada 15"),
	VENCEDOR_RODADA_16(10,"Vencedor da rodada 16"),
	VENCEDOR_RODADA_17(10,"Vencedor da rodada 17"),
	VENCEDOR_RODADA_18(10,"Vencedor da rodada 18"),
	VENCEDOR_RODADA_19(10,"Vencedor da rodada 19"),
	VENCEDOR_RODADA_20(10,"Vencedor da rodada 20"),
	VENCEDOR_RODADA_21(10,"Vencedor da rodada 21"),
	VENCEDOR_RODADA_22(10,"Vencedor da rodada 22"),
	VENCEDOR_RODADA_23(10,"Vencedor da rodada 23"),
	VENCEDOR_RODADA_24(10,"Vencedor da rodada 24"),
	VENCEDOR_RODADA_25(10,"Vencedor da rodada 25"),
	VENCEDOR_RODADA_26(10,"Vencedor da rodada 26"),
	VENCEDOR_RODADA_27(10,"Vencedor da rodada 27"),
	VENCEDOR_RODADA_28(10,"Vencedor da rodada 28"),
	VENCEDOR_RODADA_29(10,"Vencedor da rodada 29"),
	VENCEDOR_RODADA_30(10,"Vencedor da rodada 30"),
	VENCEDOR_RODADA_31(10,"Vencedor da rodada 31"),
	VENCEDOR_RODADA_32(10,"Vencedor da rodada 32"),
	VENCEDOR_RODADA_33(10,"Vencedor da rodada 33"),
	VENCEDOR_RODADA_34(10,"Vencedor da rodada 34"),
	VENCEDOR_RODADA_35(10,"Vencedor da rodada 35"),
	VENCEDOR_RODADA_36(10,"Vencedor da rodada 36"),
	VENCEDOR_RODADA_37(10,"Vencedor da rodada 37"),
	VENCEDOR_RODADA_38(10,"Vencedor da rodada 38");
	
	private Integer valor;
	private String descricao;

	PremiacoesEnum(Integer valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public Integer getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return getDescricao() + "\n";
	}
	
	
}
