package com.tcc.sisape.domain.enumdados;

public enum TipoDeAtendimento {
	CONSULTA_AGENDADA_PROGRAMADA_CUIDADO_CONTINUADO(1), CONSULTA_AGENDADA(2), ESCUTA_INICIAL_ORIENTACAO(
			4), CONSULTA_NO_DIA(
					5), ATENDIMENTO_DE_URGENCIA(6), ATENDIMENTO_PROGRAMADO(7), ATENDIMENTO_NAO_PROGRAMADO(8);

	private int tipoDeAtendimento;

	TipoDeAtendimento(int tipoDeAtendimento) {
		this.tipoDeAtendimento = tipoDeAtendimento;
	}

	public int getTipoDeAtendimento() {
		return this.tipoDeAtendimento;
	}
}
