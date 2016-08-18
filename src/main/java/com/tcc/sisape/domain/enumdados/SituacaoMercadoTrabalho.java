package com.tcc.sisape.domain.enumdados;

public enum SituacaoMercadoTrabalho {
	EMPREGADOR(66), ASSALARIADO_COM_CARTEIRA_DE_TRABALHO(67), ASSALARIADO_SEM_CARTEIRA_DE_TRABALHO(
			68), AUTONOMO_COM_PREVIDENCIA_SOCIAL(69), AUTONOMO_SEM_PREVIDENCIA_SOCIAL(
					70), APOSENTADO_PENSIONISTA(71), DESEMPREGADO(72), NAO_TRABALHA(73), OUTRO(74);

	private int situacaoMercadoTrabalho;

	SituacaoMercadoTrabalho(int situacaoMercadoTrabalho) {
		this.situacaoMercadoTrabalho = situacaoMercadoTrabalho;
	}

	public int getSituacaoMercadoTrabalho() {
		return this.situacaoMercadoTrabalho;
	}
}
