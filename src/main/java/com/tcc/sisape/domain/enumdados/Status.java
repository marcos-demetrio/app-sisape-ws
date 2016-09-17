package com.tcc.sisape.domain.enumdados;

public enum Status {
	ATIVO("A"), INATIVO("I");

	private String status;

	Status(String aStatus) {
		this.status = aStatus;
	}

	public String getStatus() {
		return this.status;
	}
}
