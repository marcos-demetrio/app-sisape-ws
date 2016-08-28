package com.tcc.sisape.domain.enumdados;

public enum EstadoCivil {
	SOLTEIRO(1), CASADO(2), DIVORCIADO(3), VIUVO(4);

	private int estadoCivil;

	EstadoCivil(int aEstadoCivil) {
		this.estadoCivil = aEstadoCivil;
	}

	public int getEstadoCivil() {
		return this.estadoCivil;
	}

}
