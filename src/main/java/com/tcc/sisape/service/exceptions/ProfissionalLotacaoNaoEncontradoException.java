package com.tcc.sisape.service.exceptions;

public class ProfissionalLotacaoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 172924434252783478L;

	public ProfissionalLotacaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ProfissionalLotacaoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
