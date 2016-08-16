package com.tcc.sisape.domain.enumdados;

public enum ConclusaoDestinoElegivel {
	ADMISSAO_PROPRIA_EMAD(1), ENCAMINHADO_PARA_OUTRA_EMAD(2), ENCAMINHADO_PARA_ATENCAO_BASICA(3), OUTRO_ENCAMINHAMENTO(
			4);

	private int conclusaoDestinoElegivel;

	ConclusaoDestinoElegivel(int conclusaoDestinoElegivel) {
		this.conclusaoDestinoElegivel = conclusaoDestinoElegivel;
	}

	public int getConclusaoDestinoElegivel() {
		return this.conclusaoDestinoElegivel;
	}
}
