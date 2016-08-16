package com.tcc.sisape.domain.enumdados;

public enum ConsideracaoPeso {
	ABAIXO_DO_PESO(21), PESO_ADEQUADO(22), ACIMA_DO_PESO(23);

	private int consideracaoPeso;

	ConsideracaoPeso(int consideracaoPeso) {
		this.consideracaoPeso = consideracaoPeso;
	}

	public int getConsideracaoPeso() {
		return this.consideracaoPeso;
	}
}
