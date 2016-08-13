package com.tcc.sisape.service.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = -2300060858184740044L;

	public UsuarioNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	
	public UsuarioNaoEncontradoException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
