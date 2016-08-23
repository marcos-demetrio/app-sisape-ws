package com.tcc.sisape.service.exceptions;

public class ClassificacaoInternacionalDoencaNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 8160391703156809391L;

	public ClassificacaoInternacionalDoencaNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public ClassificacaoInternacionalDoencaNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
