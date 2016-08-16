package com.tcc.sisape.domain.enumdados;

public enum AleitamentoMaterno {
	EXCLUSIVO(1), PREDOMINANTE(2), COMPLEMENTADO(3), INEXISTENTE(4);
	private int aleitamentoMaterno;

	AleitamentoMaterno(int aleitamentoMaterno) {
		this.aleitamentoMaterno = aleitamentoMaterno;
	}

	public int getAleitamentoMaterno() {
		return this.aleitamentoMaterno;
	}
}
