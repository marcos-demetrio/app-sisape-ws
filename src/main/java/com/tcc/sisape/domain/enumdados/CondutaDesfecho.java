package com.tcc.sisape.domain.enumdados;

public enum CondutaDesfecho {
	ALTA_ADMINISTRATIVA_DA_AD(3),
	ALTA_CLINICA_DA_AD(1),
	ENCAMINHAMENTO_PARA_ATENCAO_BASICA(2),
	URGENCIA_EMERGENCIA(4),
	INTERNACAO_HOSPITALAR(5),
	SAIDA_POR_OBITO_FINAL_DE_ACOMPANHAMENTO_POS_OBITO(6);
	
	private int condutaDesfecho;

	CondutaDesfecho(int condutaDesfecho) {
		this.condutaDesfecho = condutaDesfecho;
	}

	public int getCondutaDesfecho() {
		return this.condutaDesfecho;
	}
}
