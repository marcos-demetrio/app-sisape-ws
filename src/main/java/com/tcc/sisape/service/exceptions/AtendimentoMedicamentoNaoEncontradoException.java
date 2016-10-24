package com.tcc.sisape.service.exceptions;

public class AtendimentoMedicamentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -1038551404664780844L;

	public AtendimentoMedicamentoNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public AtendimentoMedicamentoNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
