package com.tcc.sisape.domain.enumdados;

public enum TipoAtividadeColetiva {
	REUNIAO_DE_EQUIPE(1), REUNIAO_COM_OUTRAS_EQUIPES_DE_SAUDE(
			2), REUNIAO_INTERSETORIAL_CONSELHO_LOCAL_DE_SAUDE_CONTROLE_SOCIAL(3), EDUCACAO_EM_SAUDE(
					4), ATENDIMENTO_EM_GRUPO(5), AVALIACAO_PROCEDIMENTO_COLETIVO(6), MOBILIZACAO_SOCIAL(7);

	private int tipoAtividadeColetiva;

	TipoAtividadeColetiva(int tipoAtividadeColetiva) {
		this.tipoAtividadeColetiva = tipoAtividadeColetiva;
	}

	public int getTipoAtividadeColetiva() {
		return this.tipoAtividadeColetiva;
	}
}
