package com.tcc.sisape.domain.enumdados;

public enum AleitamentoMaterno {
	EXCLUSIVO(117), PREDOMINANTE(117), COMPLEMENTADO(117), INEXISTENTE(117);
	private int aleitamentoMaterno;

	AleitamentoMaterno(int aleitamentoMaterno) {
		this.aleitamentoMaterno = aleitamentoMaterno;
	}

	public int getAleitamentoMaterno() {
		return this.aleitamentoMaterno;
	}
}
