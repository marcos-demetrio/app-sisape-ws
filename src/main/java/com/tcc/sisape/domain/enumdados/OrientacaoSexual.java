package com.tcc.sisape.domain.enumdados;

public enum OrientacaoSexual {
	HETEROSSEXUAL(5), GAY(6), LESBICA(7), BISSEXUAL(8), TRAVESTI(9), TRANSSEXUAL(10), OUTRO(11);

	private int orientacaoSexual;

	OrientacaoSexual(int orientacaoSexual) {
		this.orientacaoSexual = orientacaoSexual;
	}

	public int getOrientacaoSexual() {
		return this.orientacaoSexual;
	}
}
