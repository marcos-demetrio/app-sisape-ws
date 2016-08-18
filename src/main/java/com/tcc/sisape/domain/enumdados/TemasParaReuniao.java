package com.tcc.sisape.domain.enumdados;

public enum TemasParaReuniao {
	QUESTOES_ADMINISTRATIVAS_FUNCIONAMENTO(1), PROCESSO_DE_TRABALHO(2), DIAGNOSTICO_MONITORAMENTO_DO_TERRITORIO(
			3), PLANEJAMENTO_MONITORAMENTO_DAS_ACOES_DA_EQUIPE(
					4), DISCUSSAO_DE_CASO_OU_PROJETO_TERAPEUTICO_SINGULAR(5), EDUCACAO_PERMANENTE(6), OUTROS(7);

	private int temasParaReuniao;

	TemasParaReuniao(int temasParaReuniao) {
		this.temasParaReuniao = temasParaReuniao;
	}

	public int getTemasParaReuniao() {
		return this.temasParaReuniao;
	}
}
