package com.tcc.sisape.domain.enumdados;

public enum PeriodoDia {
	MATUTINO(1), VESPERTINO(2), NOTURNO(3);

	private int periodoDia;

	PeriodoDia(int periodoDia) {
		this.periodoDia = periodoDia;
	}

	public int getPeriodoDia() {
		return this.periodoDia;
	}
}
