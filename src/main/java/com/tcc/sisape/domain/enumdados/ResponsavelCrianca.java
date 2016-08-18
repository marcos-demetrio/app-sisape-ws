package com.tcc.sisape.domain.enumdados;

public enum ResponsavelCrianca {
	ADULTO_RESPONSAVEL(1), OUTRA_CRIANCA(2), ADOLESCENTE(133), SOZINHA(3), CRECHE(134), OUTRO(4);

	private int responsavelCrianca;

	ResponsavelCrianca(int responsavelCrianca) {
		this.responsavelCrianca = responsavelCrianca;
	}

	public int getResponsavelCrianca() {
		return this.responsavelCrianca;
	}
}
