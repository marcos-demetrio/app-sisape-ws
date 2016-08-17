package com.tcc.sisape.domain.enumdados;

public enum MotivoVisita {
	CADASTRAMENTO_ATUALIZACAO(1), VISITA_PERIODICA(29), CONSULTA(2), EXAME(3), VACINA(
			4), CONDICIONALIDADES_DE_BOLSA_FAMILIA(30), GESTANTE(5), PUERPERA(6), RECEM_NASCIDO(7), CRIANCA(
					8), PESSOA_COM_DESNUTRICAO(9), PESSOA_EM_REABILITACAO_OU_COM_DEFICIENCIA(
							10), PESSOA_COM_HIPERTENSAO(11), PESSOA_COM_DIABETES(
									12), PESSOA_COM_ASMA(13), PESSOA_COM_DPOC_ENFISEMA(14), PESSOA_COM_CANCER(
											15), PESSOA_COM_OUTRAS_DOENCAS_CRONICAS(16), PESSOA_COM_HANSENIASE(
													17), PESSOA_COM_TUBERCULOSE(18), SINTOMATICOS_RESPIRATORIOS(
															32), TABAGISTA(33), DOMICILIADOS_ACAMADOS(
																	19), CONDICOES_DE_VULNERABILIDADE_SOCIAL(
																			20), CONDICIONALIDADES_DO_BOLSA_FAMILIA(
																					21), SAUDE_MENTAL(
																							22), USUARIO_DE_ALCOOL(
																									23), USUARIO_DE_OUTRAS_DROGAS(
																											24), EGRESSO_DE_INTERNACAO(
																													25), CONTROLE_DE_AMBIENTES_VETORES(
																															26), CONVITE_PARA_ATIVIDADES_COLETIVAS_CAMPANHA_DE_SAUDE(
																																	27), ORIENTACAO_PREVENCAO(
																																			31), OUTROS(
																																					28);

	private int motivoVisita;

	MotivoVisita(int motivoVisita) {
		this.motivoVisita = motivoVisita;
	}

	public int getMotivoVisita() {
		return this.motivoVisita;
	}

}
