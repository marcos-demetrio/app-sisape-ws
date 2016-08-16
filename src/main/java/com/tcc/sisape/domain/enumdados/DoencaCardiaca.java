package com.tcc.sisape.domain.enumdados;

public enum DoencaCardiaca {
	INSUFICIENCIA_CARDIACA(117), OUTROS(117), NAO_SABE(117);

	private int doencaCardiaca;

	DoencaCardiaca(int doencaCardiaca) {
		this.doencaCardiaca = doencaCardiaca;
	}

	public int getDoencaCardiaca() {
		return this.doencaCardiaca;
	}

}
