package com.tcc.sisape.domain.enumdados;

public enum PraticasIntegrativasComplementares {
	MEDICINA_TRADICIONAL_CHINESA(1), ANTROPOSOFIA_APLICADO_A_SAUDE(2), HOMEOPATIA(3), FITOTERAPIA(
			4), TERMALISMO_CRENOTERAPIA(
					5), PRATICAS_CORPORAIS_E_MENTAIS_EM_PICS(6), TECNICAS_MANUAIS_EM_PICS(7), OOUTROS(8);

	private int praticasIntegrativasComplementares;

	PraticasIntegrativasComplementares(int praticasIntegrativasComplementares) {
		this.praticasIntegrativasComplementares = praticasIntegrativasComplementares;
	}

	public int getPraticasIntegrativasComplementares() {
		return this.praticasIntegrativasComplementares;
	}
}
