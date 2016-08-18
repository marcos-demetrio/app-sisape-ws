package com.tcc.sisape.domain.enumdados;

public enum LocalizacaoDaMoradia {
	URBANA(83), RURAL(84);

	private int localizacaoDaMoradia;

	LocalizacaoDaMoradia(int localizacaoDaMoradia) {
		this.localizacaoDaMoradia = localizacaoDaMoradia;
	}

	public int getLocalizacaoDaMoradia() {
		return this.localizacaoDaMoradia;
	}
}
