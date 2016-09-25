package com.tcc.sisape.service.exceptions;

public class ProfissionalNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 4240615828883599353L;

	public ProfissionalNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ProfissionalNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
