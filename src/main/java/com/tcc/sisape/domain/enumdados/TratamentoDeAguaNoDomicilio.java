package com.tcc.sisape.domain.enumdados;

public enum TratamentoDeAguaNoDomicilio {
	FILTRACAO(97), FERVURA(98), CLORACAO(99), SEM_TRATAMENTO(100);

	private int tratamentoDeAguaNoDomicilio;

	TratamentoDeAguaNoDomicilio(int tratamentoDeAguaNoDomicilio) {
		this.tratamentoDeAguaNoDomicilio = tratamentoDeAguaNoDomicilio;
	}

	public int getTratamentoDeAguaNoDomicilio() {
		return this.tratamentoDeAguaNoDomicilio;
	}
}
