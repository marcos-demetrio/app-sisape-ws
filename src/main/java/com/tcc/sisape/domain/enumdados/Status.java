package com.tcc.sisape.domain.enumdados;

public enum Status {
	ATIVO(1), INATIVO(0);

	private int status;

	Status(int aStatus) {
		this.status = aStatus;
	}

	public int getStatus() {
		return this.status;
	}
}
