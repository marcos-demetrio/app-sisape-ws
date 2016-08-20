package com.tcc.sisape.service.exceptions;

public class PaisNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 8897307831211241034L;

	public PaisNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public PaisNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
