package com.tcc.sisape.domain.enumdados;

public enum RendaFamiliar {
	UM_QUARTO_DE_SALARIO_MINIMO(1), MEIO_SALARIO_MINIMO(2), UM_SALARIO_MINIMO(3), DOIS_SALARIOS_MINIMOS(
			4), TRES_SALARIO_MINIMOS(7), QUATRO_SALARIOS_MINIMOS(5), ACIMA_DE_QUATRO_SALARIOS_MINIMOS(6);

	private int rendaFamiliar;

	RendaFamiliar(int rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}

	public int getRendaFamiliar() {
		return this.rendaFamiliar;
	}
}
