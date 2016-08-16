package com.tcc.sisape.domain.enumdados;

public enum AnimalNoDomicilio {
	GATO(128), CACHORRO(129), PASSARO(130), DE_CRIACAO(131), OUTROS(132);

	private int animalNoDomicilio;

	AnimalNoDomicilio(int animalNoDomicilio) {
		this.animalNoDomicilio = animalNoDomicilio;
	}

	public int getAnimalNoDomicilio() {
		return this.animalNoDomicilio;
	}
}
