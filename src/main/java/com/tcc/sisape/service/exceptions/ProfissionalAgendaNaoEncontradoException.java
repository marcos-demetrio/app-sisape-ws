package com.tcc.sisape.service.exceptions;

public class ProfissionalAgendaNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -9220860737630846554L;

	public ProfissionalAgendaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ProfissionalAgendaNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
