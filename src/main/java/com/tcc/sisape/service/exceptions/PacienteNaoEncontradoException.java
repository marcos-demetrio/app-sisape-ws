package com.tcc.sisape.service.exceptions;

public class PacienteNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 8897307831211241034L;

	public PacienteNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	
	public PacienteNaoEncontradoException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
