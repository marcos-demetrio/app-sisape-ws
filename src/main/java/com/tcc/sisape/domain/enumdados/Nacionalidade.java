package com.tcc.sisape.domain.enumdados;

public enum Nacionalidade {
	BRASILEIRA(1), NATURALIZADO(2), ESTRANGEIRO(3);

	private int nacionalidade;

	Nacionalidade(int nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public int getNacionalidade() {
		return this.nacionalidade;
	}

}
