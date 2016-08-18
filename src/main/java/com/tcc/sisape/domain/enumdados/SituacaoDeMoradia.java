package com.tcc.sisape.domain.enumdados;

public enum SituacaoDeMoradia {
	PROPRIO(75), FINANCIADO(76), ALUGADO(77), ARRENDADO(78), CEDIDO(79), OCUPACAO(80), SITUACAO_DE_RUA(81), OUTRA(82);

	private int situacaoDeMoradia;

	SituacaoDeMoradia(int situacaoDeMoradia) {
		this.situacaoDeMoradia = situacaoDeMoradia;
	}

	public int getSituacaoDeMoradia() {
		return this.situacaoDeMoradia;
	}
}
