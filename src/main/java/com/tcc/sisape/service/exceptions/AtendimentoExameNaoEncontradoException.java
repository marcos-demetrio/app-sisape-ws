package com.tcc.sisape.service.exceptions;

public class AtendimentoExameNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 6808172275668119991L;

	public AtendimentoExameNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public AtendimentoExameNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
