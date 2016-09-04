package com.tcc.sisape.domain.enumdados;

public enum RacaCor {
	BRANCA(0), PRETA(1), PARDA(2), AMARELA(3), INDIGENA(4);

	private int racaCor;

	RacaCor(int racaCor) {
		this.racaCor = racaCor;
	}

	public int getRacaCor() {
		return this.racaCor;
	}
}
