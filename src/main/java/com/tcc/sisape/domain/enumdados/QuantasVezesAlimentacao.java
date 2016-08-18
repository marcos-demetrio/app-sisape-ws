package com.tcc.sisape.domain.enumdados;

public enum QuantasVezesAlimentacao {
	UMA_VEZ(34), DUAS_OU_TRES_VEZES(35), MAIS_DE_TRES_VEZES(36);

	private int quantasVezesAlimentacao;

	QuantasVezesAlimentacao(int quantasVezesAlimentacao) {
		this.quantasVezesAlimentacao = quantasVezesAlimentacao;
	}

	public int getQuantasVezesAlimentacao() {
		return this.quantasVezesAlimentacao;
	}
}
