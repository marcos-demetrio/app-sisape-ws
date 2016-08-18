package com.tcc.sisape.domain.enumdados;

public enum TempoSituacaoDeRua {
	MENOS_DE_SEIS_MESES(17), SEIS_A_DOZE_MESES(18), UM_A_CINCO_ANOS(19), MAIS_DE_CINCO_ANOS(20);

	private int tempoSituacaoDeRua;

	TempoSituacaoDeRua(int tempoSituacaoDeRua) {
		this.tempoSituacaoDeRua = tempoSituacaoDeRua;
	}

	public int getTempoSituacaoDeRua() {
		return this.tempoSituacaoDeRua;
	}
}
