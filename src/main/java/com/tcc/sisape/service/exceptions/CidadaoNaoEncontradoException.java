package com.tcc.sisape.service.exceptions;

public class CidadaoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 8897307831211241034L;

	public CidadaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public CidadaoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
