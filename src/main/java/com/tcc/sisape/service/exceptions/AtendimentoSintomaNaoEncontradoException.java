package com.tcc.sisape.service.exceptions;

public class AtendimentoSintomaNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -5233240380283067160L;

	public AtendimentoSintomaNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public AtendimentoSintomaNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
