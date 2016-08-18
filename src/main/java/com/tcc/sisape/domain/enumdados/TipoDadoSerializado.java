package com.tcc.sisape.domain.enumdados;

public enum TipoDadoSerializado {
	FICHA_DE_CADASTRO_INDIVIDUAL(2), FICHA_DE_CADASTRO_DOMICILIAR(3), FICHA_DE_ATENDIMENTO_INDIVIDUAL(
			4), FICHA_DE_ATENDIMENTO_ODONTOLOGICO(5), FICHA_DE_ATIVIDADE_COLETIVA(6), FICHA_DE_PROCEDIMENTOS(
					7), FICHA_DE_VISITA_DOMICILIAR(8), FICHA_DE_ATENDIMENTO_DOMICILIAR(
							10), FICHA_DE_AVALIACAO_DE_ELEGIBILIDADE(11), MARCADORES_DE_CONSIIMO_ALIMENTAR(12);

	private int tipoDadoSerializado;

	TipoDadoSerializado(int tipoDadoSerializado) {
		this.tipoDadoSerializado = tipoDadoSerializado;
	}

	public int getTipoDadoSerializado() {
		return this.tipoDadoSerializado;
	}
}
