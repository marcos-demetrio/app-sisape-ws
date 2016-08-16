package com.tcc.sisape.domain.enumdados;

public enum AtencaoDomiciliarOrigem {
	UBS(1), OUTROS(6), HOSPITAL(11), UNIDADE_PRONTO_ATENDIMENTO(12), CACON_UNACON(13), URGENCIA_EMERGIA_HOSPITAL(
			14), HOSPITAL_SOS_DEMAIS_SETORES(15);

	private int atencaoDomiciliarOrigem;

	AtencaoDomiciliarOrigem(int atencaoDomiciliarOrigem) {
		this.atencaoDomiciliarOrigem = atencaoDomiciliarOrigem;
	}

	public int getAtencaoDomiciliarOrigem() {
		return this.atencaoDomiciliarOrigem;
	}
}
