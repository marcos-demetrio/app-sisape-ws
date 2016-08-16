package com.tcc.sisape.domain.enumdados;

public enum CuidadorCidadao {
	NAO_POSSUI(1), CONJUGE_COMPANHEIRO(2), FILHO_ENTEADO(3), PAI_MAE(4), AVO(5), NETO(6), IRMAO(7), OUTRO(8);

	private int cuidadorCidadao;

	CuidadorCidadao(int cuidadorCidadao) {
		this.cuidadorCidadao = cuidadorCidadao;
	}

	public int getCuidadorCidadao() {
		return this.cuidadorCidadao;
	}
}
