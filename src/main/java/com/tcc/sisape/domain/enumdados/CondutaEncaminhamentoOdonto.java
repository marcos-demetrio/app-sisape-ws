package com.tcc.sisape.domain.enumdados;

public enum CondutaEncaminhamentoOdonto {
	RETORNO_PARA_CONSULTA_AGENDADA(16), AGENDAMENTO_PARA_OUTROS_PROFISSIONAIS_AB(12), AGENDAMENTO_PARA_NASF(
			13), AGENDAMENTO_PARA_OUTROS_GRUPOS(14), TRATAMENTO_CONCLUIDO(
					15), ATENDIMENTO_A_PACIENTES_COM_NECESSIDADES_ESPECIAIS(1), CIRURGIA_BMF(2), ENDODONTIA(
							3), ESTOMATOLOGIA(4), IMPLANTODONTIA(5), ODONTOPEDIATRIA(6), ORTODONTIA_ORTOPEDIA(
									7), PERIODONTIA(8), PROTESE_DENTARIA(9), RADIOLOGIA(10), OUTROS(11);

	private int condutaEncaminhamentoOdonto;

	CondutaEncaminhamentoOdonto(int condutaEncaminhamentoOdonto) {
		this.condutaEncaminhamentoOdonto = condutaEncaminhamentoOdonto;
	}

	public int getCondutaEncaminhamentoOdonto() {
		return this.condutaEncaminhamentoOdonto;
	}
}
