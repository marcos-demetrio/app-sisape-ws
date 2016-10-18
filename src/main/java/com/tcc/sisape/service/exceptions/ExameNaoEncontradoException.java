package com.tcc.sisape.service.exceptions;

public class ExameNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -4336913932857976728L;

	public ExameNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public ExameNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
