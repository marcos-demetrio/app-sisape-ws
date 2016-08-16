package com.tcc.sisape.domain.enumdados;

public enum DoencaCardiaca {
	INSUFICIENCIA_CARDIACA(24), OUTROS(25), NAO_SABE(26);

	private int doencaCardiaca;

	DoencaCardiaca(int doencaCardiaca) {
		this.doencaCardiaca = doencaCardiaca;
	}

	public int getDoencaCardiaca() {
		return this.doencaCardiaca;
	}

}
