package com.tcc.sisape.domain.enumdados;

public enum FormaDeEscoamentoDoBanheiroOuSanitario {
	REDE_COLETORA_DE_ESGOTO(122), FOSSA_SEPTICA(123), FOSSA_RUDIMENTAR(124), DIRETO_PARA_UM_RIO_LAGO_MAR(
			125), CEU_ABERTO(126), OUTRA_FORMA(127);

	private int formaDeEscoamentoDoBanheiroOuSanitario;

	FormaDeEscoamentoDoBanheiroOuSanitario(int formaDeEscoamentoDoBanheiroOuSanitario) {
		this.formaDeEscoamentoDoBanheiroOuSanitario = formaDeEscoamentoDoBanheiroOuSanitario;
	}

	public int getFormaDeEscoamentoDoBanheiroOuSanitario() {
		return this.formaDeEscoamentoDoBanheiroOuSanitario;
	}
}
