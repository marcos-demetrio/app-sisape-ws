package com.tcc.sisape.service.exceptions;

public class UnidadeBasicaSaudeZonaAtendimentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 3665220454406628857L;

	public UnidadeBasicaSaudeZonaAtendimentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public UnidadeBasicaSaudeZonaAtendimentoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
