package com.tcc.sisape.domain.enumdados;

public enum OrigemAlimentacao {
	RESTAURANTE_POPULAR(37), DOACAO_GRUPO_RELIGIOSO(38), DOACAO_RESTAURANTE(39), DOACAO_POPULAR(40), OUTROS(41);

	private int origemAlimentacao;

	OrigemAlimentacao(int origemAlimentacao) {
		this.origemAlimentacao = origemAlimentacao;
	}

	public int getOrigemAlimentacao() {
		return this.origemAlimentacao;
	}
}
