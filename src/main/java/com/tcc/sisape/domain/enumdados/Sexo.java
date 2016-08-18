package com.tcc.sisape.domain.enumdados;

public enum Sexo {
	MASCULINO(0), FEMININO(1);

	private int sexo;

	Sexo(int sexo) {
		this.sexo = sexo;
	}

	public int getSexo() {
		return this.sexo;
	}
}
