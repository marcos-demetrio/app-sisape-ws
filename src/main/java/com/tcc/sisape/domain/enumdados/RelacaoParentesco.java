package com.tcc.sisape.domain.enumdados;

public enum RelacaoParentesco {
	CONJUGE_COMPANHEIRO(137), FILHO(138), ENTEADO(139), NETO_BISNETO(140), PAI_MAE(141), SOGRO(142), IRMAO(143), GENRO(
			144), OUTRO_PARENTE(145), NAO_PARENTE(146);

	private int relacaoParentesco;

	RelacaoParentesco(int relacaoParentesco) {
		this.relacaoParentesco = relacaoParentesco;
	}

	public int getRelacaoParentesco() {
		return this.relacaoParentesco;
	}
}
