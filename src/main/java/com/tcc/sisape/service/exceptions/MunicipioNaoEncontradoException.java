package com.tcc.sisape.service.exceptions;

public class MunicipioNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -2255046176551573016L;

	public MunicipioNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public MunicipioNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
