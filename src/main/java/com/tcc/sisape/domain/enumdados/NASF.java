package com.tcc.sisape.domain.enumdados;

public enum NASF {
	AVALIACAO_DIAGNOSTICO(1), PROCEDIMENTOS_CLINICOS_TERAPEUTICOS(2), PRESCRICAO_TERAPEUTICA(3);

	private int nasf;

	NASF(int nasf) {
		this.nasf = nasf;
	}

	public int getNASF() {
		return this.nasf;
	}
}
