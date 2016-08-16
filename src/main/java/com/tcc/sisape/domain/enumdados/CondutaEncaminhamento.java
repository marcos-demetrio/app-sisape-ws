package com.tcc.sisape.domain.enumdados;

public enum CondutaEncaminhamento {
	RETORNO_PARA_CONSULTA_AGENDADA(1), RETORNO_PARA_CUIDADO_CONTINUADO_PROGRAMADO(2), AGENDAMENTO_PARA_GRUPOS(
			12), AGENDAMENTO_PARA_NASF(3), ALTA_DO_EPISODIO(9), ENCAMINHAMENTO_INTERNO_NO_DIA(
					11), ENCAMINHAMENTO_PARA_SERVICO_ESPECIALIZADO(4), ENCAMINHAMENTO_PARA_CAPS(
							5), ENCAMINHAMENTO_PARA_INTERNACAO_HOSPITALAR(6), ENCAMINHAMENTO_PARA_URGENCIA(
									7), ENCAMINHAMENTO_PARA_SERVICO_DE_ATENCAO_DOMICILIAR(
											8), ENCAMINHAMENTO_INTERSETORIAL(10);

	private int condutaEncaminhamento;

	CondutaEncaminhamento(int condutaEncaminhamento) {
		this.condutaEncaminhamento = condutaEncaminhamento;
	}

	public int getCondutaEncaminhamento() {
		return this.condutaEncaminhamento;
	}
}
