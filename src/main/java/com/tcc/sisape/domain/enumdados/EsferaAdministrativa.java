package com.tcc.sisape.domain.enumdados;

public enum EsferaAdministrativa {
	FEDERAL("F"), ESTADUAL("E"), MUNICIPAL("M");

	private String esferaAdministrativa;

	EsferaAdministrativa(String esferaAdministrativa) {
		this.esferaAdministrativa = esferaAdministrativa;
	}
	
	public String getDescricao(){
		return this.esferaAdministrativa;
	}
}
