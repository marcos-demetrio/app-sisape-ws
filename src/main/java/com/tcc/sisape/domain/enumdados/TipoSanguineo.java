package com.tcc.sisape.domain.enumdados;

public enum TipoSanguineo {
	TIPO_A_POSITIVO(1), TIPO_A_NEGATIVO(2), TIPO_B_POSITIVO(3), TIPO_B_NEGATIVO(4), TIPO_AB_POSITIVO(
			5), TIPO_AB_NEGATIVO(6), TIPO_O_POSITIVO(7), TIPO_O_NEGATIVO(8);

	private int tipoSanguineo;

	TipoSanguineo(int aTipoSanguineo) {
		this.tipoSanguineo = aTipoSanguineo;
	}

	public int getTipoSanguineo() {
		return this.tipoSanguineo;
	}
}