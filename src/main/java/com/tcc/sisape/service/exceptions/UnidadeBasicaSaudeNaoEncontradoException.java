package com.tcc.sisape.service.exceptions;

public class UnidadeBasicaSaudeNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = -8567989953448522142L;

	public UnidadeBasicaSaudeNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	
	public UnidadeBasicaSaudeNaoEncontradoException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
