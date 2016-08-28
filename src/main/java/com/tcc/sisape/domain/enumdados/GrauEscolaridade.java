package com.tcc.sisape.domain.enumdados;

public enum GrauEscolaridade {

	FUNDAMENTAL_INCOMPLETO(1), FUNDAMENTAL_COMPLETO(2), MEDIO_INCOMPLETO(3), MEDIO_COMPLETO(4), SUPERIOR_INCOMPLETO(
			5), SUPERIOR_COMPLETO(6), POS_GRADUACAO_LATO_SENSO_INCOMPLETO(7), POS_GRADUACAO_LATO_SENSO_COMPLETO(
					8), POS_GRADUACAO_STRICTO_SENSO_NIVEL_MESTRADO_INCOMPLETO(
							9), POS_GRADUACAO_STRICTO_SENSO_NIVEL_MESTRADO_COMPLETO(
									10), POS_GRADUACAO_STRICTO_SENSO_NIVEL_DOUTOR_INCOMPLETO(
											11), POS_GRADUACAO_STRICTO_SENSO_NIVEL_DOUTOR_COMPLETO(12);

	private int grauEscolaridade;

	GrauEscolaridade(int aGrauEscolaridade) {
		this.grauEscolaridade = aGrauEscolaridade;
	}

	public int getGrauEscolaridade() {
		return this.grauEscolaridade;
	}
}
