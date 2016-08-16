package com.tcc.sisape.domain.enumdados;

public enum ConclusaoDestinoInelegivel {
	INSTABILIDADE_CLINICA(1), NECESSIDADE_PROPEDEUTICA(2), OUTRO_MOTIVO(3), AUSENCIA_DE_CUIDADOR(
			4), OUTRAS_CONDICOES_SOCIAIS(5);

	private int conclusaoDestinoInelegivel;

	ConclusaoDestinoInelegivel(int conclusaoDestinoInelegivel) {
		this.conclusaoDestinoInelegivel = conclusaoDestinoInelegivel;
	}

	public int getConclusaoDestinoInelegivel() {
		return this.conclusaoDestinoInelegivel;
	}
}
