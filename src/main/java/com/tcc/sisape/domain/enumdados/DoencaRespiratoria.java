package com.tcc.sisape.domain.enumdados;

public enum DoencaRespiratoria {
	ASMA(30), DPOC_ENFISEMA(31), OUTRO(32), NAO_SABE(33);

	private int doencaRespiratoria;

	DoencaRespiratoria(int doencaRespiratoria) {
		this.doencaRespiratoria = doencaRespiratoria;
	}

	public int getDoencaRespiratoria() {
		return this.doencaRespiratoria;
	}
}
