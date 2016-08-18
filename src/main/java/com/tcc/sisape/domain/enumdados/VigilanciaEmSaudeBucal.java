package com.tcc.sisape.domain.enumdados;

public enum VigilanciaEmSaudeBucal {
	ABSCESSO_DENTO_ALVEOLAR(1), ALTERACAO_EM_TECIDOS_MOLES(2), DOR_DE_DENTE(3), FENDAS_FISSURAS_LABIO_PALATAIS(
			4), FLUOROSE_DENTARIA_MODERADA_SEVERA(5), TRAUMATISMO_DENTO_ALVEOLAR(6), NAO_IDENTIFICADO(99);

	private int vigilanciaEmSaudeBucal;

	VigilanciaEmSaudeBucal(int vigilanciaEmSaudeBucal) {
		this.vigilanciaEmSaudeBucal = vigilanciaEmSaudeBucal;
	}

	public int getVigilanciaEmSaudeBucal() {
		return this.vigilanciaEmSaudeBucal;
	}
}
