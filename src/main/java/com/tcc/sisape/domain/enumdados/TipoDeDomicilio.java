package com.tcc.sisape.domain.enumdados;

public enum TipoDeDomicilio {
	CASA(85), APARTAMENTO(86), COMODO(87), OUTRO(88);

	private int tipoDeDomicilio;

	TipoDeDomicilio(int tipoDeDomicilio) {
		this.tipoDeDomicilio = tipoDeDomicilio;
	}

	public int getTipoDeDomicilio() {
		return this.tipoDeDomicilio;
	}
}
