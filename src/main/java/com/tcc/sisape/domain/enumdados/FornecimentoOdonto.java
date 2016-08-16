package com.tcc.sisape.domain.enumdados;

public enum FornecimentoOdonto {
	ESCOVA_DENTAL(1), CREME_DENTAL(2), FIO_DENTAL(3);

	private int fornecimentoOdonto;

	FornecimentoOdonto(int fornecimentoOdonto) {
		this.fornecimentoOdonto = fornecimentoOdonto;
	}

	public int getFornecimentoOdonto() {
		return this.fornecimentoOdonto;
	}

}
