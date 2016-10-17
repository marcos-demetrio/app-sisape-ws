package com.tcc.sisape.service.exceptions;

public class AgendamentoSintomaNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -1759852314192201477L;

	public AgendamentoSintomaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public AgendamentoSintomaNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
