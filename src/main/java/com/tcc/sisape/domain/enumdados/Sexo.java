package com.tcc.sisape.domain.enumdados;

public enum Sexo {
	MASCULINO("M"),	FEMININO("F");
	
	private String sexo;
	
	Sexo(String sexo){
		this.sexo = sexo;
	}
	
	public String getDescricao(){
		return this.sexo;
	}
}
