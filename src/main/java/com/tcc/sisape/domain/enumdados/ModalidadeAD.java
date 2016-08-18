package com.tcc.sisape.domain.enumdados;

public enum ModalidadeAD {
	AD_1(1), AD_2(2), AD_3(3), INELEGIVEL(4);

	private int modalidadeAD;

	ModalidadeAD(int modalidadeAD) {
		this.modalidadeAD = modalidadeAD;
	}

	public int getModalidadeAD() {
		return this.modalidadeAD;
	}
}
