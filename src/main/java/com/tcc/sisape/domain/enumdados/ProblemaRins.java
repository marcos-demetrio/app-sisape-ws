package com.tcc.sisape.domain.enumdados;

public enum ProblemaRins {
	INSUFICIENCIA_RENAL(27), OUTRO(28), NAO_SABE(29);

	private int problemaRins;

	ProblemaRins(int problemaRins) {
		this.problemaRins = problemaRins;
	}

	public int getProblemaRins() {
		return this.problemaRins;
	}
}
