package com.tcc.sisape.domain.enumdados;

public enum CursoMaisElevado {
	CRECHE(51), PRE_ESCOLA_EXCETO_CA(52), CLASSE_ALFABETIZADA_CA(53), ENSINO_FUNDAMENTO_1_A_4_SERIES(
			54), ENSINO_FUNDAMENTO_5_A_8_SERIES(55), ENSINO_FUNDAMENTO_COMPLETO(56), ENSINO_FUNDAMENTO_ESPECIAL(
					61), ENSINO_FUNDAMENTO_EJA_SERIES_INICIAIS_SUPLETIVO_1_A_4(
							58), ENSINO_FUNDAMENTO_EJA_SERIES_FINAIS_SUPLETIVO_5_A_8(
									59), ENSINO_MEDIO_MEDIO_2_CICLO_CIENTIFICO_TECNICO_ETC(60), ENSINO_MEDIO_ESPECIAL(
											57), ENSINO_MEDIO_EJA(
													62), SUPERIOR_APERFEICOAMENTO_ESPECIALIZACAO_MESTRADO_DOUTORADO(
															63), ALFABETIZACAO_PARA_ADULTOS(64), NENHUM(65);

	private int cursoMaisElevado;

	CursoMaisElevado(int cursoMaisElevado) {
		this.cursoMaisElevado = cursoMaisElevado;
	}

	public int getCursoMaisElevado() {
		return this.cursoMaisElevado;
	}
}
