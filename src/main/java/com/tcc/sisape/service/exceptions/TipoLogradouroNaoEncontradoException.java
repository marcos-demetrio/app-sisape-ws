package com.tcc.sisape.service.exceptions;

public class TipoLogradouroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 4813774378102985181L;

	public TipoLogradouroNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public TipoLogradouroNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
