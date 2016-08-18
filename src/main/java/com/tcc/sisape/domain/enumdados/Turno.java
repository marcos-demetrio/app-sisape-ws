package com.tcc.sisape.domain.enumdados;

public enum Turno {
	MATUTINO(1), VESPERTINO(2), NOTURNO(3);

	private int turno;

	Turno(int turno) {
		this.turno = turno;
	}

	public int getTurno() {
		return this.turno;
	}
}
