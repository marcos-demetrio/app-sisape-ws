package com.tcc.sisape.domain.enumdados;

public enum DiaSemana {
	DOMINGO(1),
	SEGUNDA_FEIRA(2),
	TERCA_FEIRA(3),
	QUARTA_FEIRA(4),
	QUINTA_FEIRA(5),
	SEXTA_FEIRA(6),
	SABADO(7);
	
	private int diaSemana;
	
	DiaSemana(int diaSemana){
		this.diaSemana = diaSemana;
	}
	
	public int getDiaSemana(){
		return this.diaSemana;
	}
}
