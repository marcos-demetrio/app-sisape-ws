package com.tcc.sisape.domain.enumdados;

public enum EsferaAdministrativa {
	PUBLICO_FEDERAL(1), PUBLICO_ESTADUAL(3), PUBLICO_MUNICIPAL(3);

	private int esferaAdministrativa;

	EsferaAdministrativa(int esferaAdministrativa) {
		this.esferaAdministrativa = esferaAdministrativa;
	}

	public int getEsferaAdministrativa() {
		return this.esferaAdministrativa;
	}
}
