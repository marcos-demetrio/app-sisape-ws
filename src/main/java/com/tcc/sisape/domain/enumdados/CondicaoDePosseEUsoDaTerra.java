package com.tcc.sisape.domain.enumdados;

public enum CondicaoDePosseEUsoDaTerra {
	PROPRIETARIO(101), PARCEIRO_MEEIRO(102), ASSENTADO(103), POSSEIRO(104), ARRENDATARIO(105), COMODATARIO(
			106), BENEFICIARIO_DO_BANCO_DA_TERRA(107), NAO_SE_APLICA(108);

	private int condicaoDePosseEUsoDaTerra;

	CondicaoDePosseEUsoDaTerra(int condicaoDePosseEUsoDaTerra) {
		this.condicaoDePosseEUsoDaTerra = condicaoDePosseEUsoDaTerra;
	}

	public int getCondicaoDePosseEUsoDaTerra() {
		return this.condicaoDePosseEUsoDaTerra;
	}
}
