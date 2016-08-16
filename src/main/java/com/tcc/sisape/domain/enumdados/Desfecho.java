package com.tcc.sisape.domain.enumdados;

public enum Desfecho {
	VISITA_REALIZADA(1), VISITA_RECUSADA(2), AUSENTE(3);

	private int desfecho;

	Desfecho(int desfecho) {
		this.desfecho = desfecho;
	}

	public int getDesfecho() {
		return this.desfecho;
	}

}
