package com.tcc.sisape.service.exceptions;

public class EstadoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 8444039657539703818L;

	public EstadoNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public EstadoNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
