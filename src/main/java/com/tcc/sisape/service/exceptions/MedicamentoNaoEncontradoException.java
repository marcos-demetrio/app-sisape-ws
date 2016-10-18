package com.tcc.sisape.service.exceptions;

public class MedicamentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 4627387394857197076L;

	public MedicamentoNaoEncontradoException(String aMensagem) {
		super(aMensagem);
	}

	public MedicamentoNaoEncontradoException(String aMensagem, Throwable aCausa) {
		super(aMensagem, aCausa);
	}
}
