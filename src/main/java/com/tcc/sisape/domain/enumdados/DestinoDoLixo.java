package com.tcc.sisape.domain.enumdados;

public enum DestinoDoLixo {
	COLETADO(93), QUEIMADO_ENTERRADO(94), CEU_ABERTO(95), OUTRO(96);

	private int destinoDoLixo;

	DestinoDoLixo(int destinoDoLixo) {
		this.destinoDoLixo = destinoDoLixo;
	}

	public int getDestinoDoLixo() {
		return this.destinoDoLixo;
	}
}
