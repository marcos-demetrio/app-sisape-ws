package com.tcc.sisape.service.exceptions;

public class ClassificacaoBrasileiraOcupacaoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -3937448736229000291L;

	public ClassificacaoBrasileiraOcupacaoNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public ClassificacaoBrasileiraOcupacaoNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
