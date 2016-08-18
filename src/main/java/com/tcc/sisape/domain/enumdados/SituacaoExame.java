package com.tcc.sisape.domain.enumdados;

public enum SituacaoExame {
	SOLICITADO("S"), AVALIADO("A");

	private String situacaoExame;

	SituacaoExame(String situacaoExame) {
		this.situacaoExame = situacaoExame;
	}

	public String getSituacaoExame() {
		return this.situacaoExame;
	}
}
