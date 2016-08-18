package com.tcc.sisape.domain.enumdados;

public enum TipoDeConsultaOdonto {
	PRIMEIRA_CONSULTA_ODONTOLOGICA_PROGRAMATICA(1), CONSULTA_DE_RETORNO(2), CONSULTA_DE_MANUTENCAO(4);

	private int tipoDeConsultaOdonto;

	TipoDeConsultaOdonto(int tipoDeConsultaOdonto) {
		this.tipoDeConsultaOdonto = tipoDeConsultaOdonto;
	}

	public int getTipoDeConsultaOdonto() {
		return this.tipoDeConsultaOdonto;
	}
}
