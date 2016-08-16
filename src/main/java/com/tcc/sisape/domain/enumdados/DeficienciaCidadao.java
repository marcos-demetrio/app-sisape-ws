package com.tcc.sisape.domain.enumdados;

public enum DeficienciaCidadao {
	AUDITIVA(12), VISUAL(13), INTELECTUAL_COGNITIVA(14), FISICA(15), OUTRA(16);

	private int deficienciaCidadao;

	DeficienciaCidadao(int deficienciaCidadao) {
		this.deficienciaCidadao = deficienciaCidadao;
	}

	public int getDeficienciaCidadao() {
		return this.deficienciaCidadao;
	}
}
