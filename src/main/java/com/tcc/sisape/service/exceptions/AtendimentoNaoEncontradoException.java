package com.tcc.sisape.service.exceptions;

public class AtendimentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -2439819443337333297L;

	public AtendimentoNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public AtendimentoNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
