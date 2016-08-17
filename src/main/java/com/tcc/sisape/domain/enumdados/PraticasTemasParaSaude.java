package com.tcc.sisape.domain.enumdados;

public enum PraticasTemasParaSaude {
	ALIMENTACAO_SAUDAVEL(1), APLICACAO_TOPICA_DE_FLUOR(2), SAUDE_OCULAR(3), AUTOCUIDADO_DE_PESSOAS_COM_DOENCAS_CRONICAS(
			4), CIDADANIA_E_DIREITOS_HUMANOS(5), SAUDE_DO_TRABALHADOR(
					6), DEPENDENCIA_QUIMICA_TABACO_ALCOOL_OUTRAS_DROGAS(7), ENVELHECIMENTO_CLIMATERIO_ANDROPAUSA_ETC(
							8), ESCOVACAO_DENTARIA_SUPERVISIONADA(9), PLANTAS_MEDICINAIS_FITOTERAPIA(
									10), PRATICAS_CORPORAIS_ATIVIDADE_FISICA(11), PRATICAS_CORPORAIS_E_MENTAIS_EM_PI(
											12), PREVENCAO_DA_VIOLENCIA_E_PROMOCAO_DA_CULTURA_DA_PAZ(
													13), SAUDE_AMBIENTAL(14), SAUDE_BUCAL(15), SAUDE_MENTAL(
															16), SAUDE_SEXUAL_E_REPRODUTIVA(17), SEMANA_SAUDE_NA_ESCOLA(
																	18), AGRAVOS_NEGLIGENCIADOS(19), ANTROPOMETRIA(
																			20), OUTROS(21), SAUDE_AUDITIVA(
																					22), DESENVOLVIMENTO_DA_LINGUAGEM(
																							23), VERIFICACAO_DA_SITUACAO_VACINAL(
																									24), PNCT_1(
																											25), PNCT_2(
																													26), PNCT_3(
																															27), PNCT_4(
																																	28);

	private int praticasTemasParaSaude;

	PraticasTemasParaSaude(int praticasTemasParaSaude) {
		this.praticasTemasParaSaude = praticasTemasParaSaude;
	}

	public int getPraticasTemasParaSaude() {
		return this.praticasTemasParaSaude;
	}

}
