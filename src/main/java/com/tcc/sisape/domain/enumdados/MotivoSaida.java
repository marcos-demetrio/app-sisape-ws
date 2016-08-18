package com.tcc.sisape.domain.enumdados;

public enum MotivoSaida {
	OBITO(135), MUDANCA_DE_TERRITORIO(136);

	private int motivoSaida;

	MotivoSaida(int motivoSaida) {
		this.motivoSaida = motivoSaida;
	}

	public int getMotivoSaida() {
		return this.motivoSaida;
	}
}
