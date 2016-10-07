package com.tcc.sisape.service.exceptions;

public class AgendamentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -1759852314192201477L;

	public AgendamentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public AgendamentoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
