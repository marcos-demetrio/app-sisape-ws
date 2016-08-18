package com.tcc.sisape.domain.enumdados;

public enum RacaCor {
	BRANCA(1), PRETA(2), PARDA(3), AMARELA(4), INDIGENA(5);

	private int racaCor;

	RacaCor(int racaCor) {
		this.racaCor = racaCor;
	}

	public int getRacaCor() {
		return this.racaCor;
	}
}
