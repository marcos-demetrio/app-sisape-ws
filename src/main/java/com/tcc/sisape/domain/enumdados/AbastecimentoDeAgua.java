package com.tcc.sisape.domain.enumdados;

public enum AbastecimentoDeAgua {
	REDE_ENCANADA_ATE_O_MUNICIPIO(117), POCO_NASCENTE_NO_DOMICILIO(118), CISTERNA(119), CARRO_PIPA(120), OUTRO(121);

	private int abastecimentoDeAgua;

	AbastecimentoDeAgua(int abastecimentoDeAgua) {
		this.abastecimentoDeAgua = abastecimentoDeAgua;
	}

	public int getAbastecimentoDeAgua() {
		return this.abastecimentoDeAgua;
	}
}
