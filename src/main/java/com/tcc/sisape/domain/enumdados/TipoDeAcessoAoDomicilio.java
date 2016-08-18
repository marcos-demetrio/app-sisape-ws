package com.tcc.sisape.domain.enumdados;

public enum TipoDeAcessoAoDomicilio {
	PAVIMENTO(89), CHAO_BATIDO(90), FLUVIAL(91), OUTRO(92);

	private int tipoDeAcessoAoDomicilio;

	TipoDeAcessoAoDomicilio(int tipoDeAcessoAoDomicilio) {
		this.tipoDeAcessoAoDomicilio = tipoDeAcessoAoDomicilio;
	}

	public int getTipoDeAcessoAoDomicilio() {
		return this.tipoDeAcessoAoDomicilio;
	}
}
