package com.tcc.sisape.service.exceptions;

public class UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -8567989953448522142L;

	public UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
