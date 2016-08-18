package com.tcc.sisape.domain.enumdados;

public enum PublicoAlvo {
	COMUNIDADE_EM_GERAL(1), CRIANCA_DE_0_A_3_ANOS(2), CRIANCA_DE_4_A_5_ANOS(3), CRIANCA_DE_6_A_11_ANOS(4), ADOLESCENTE(
			5), MULHER(6), GESTANTE(7), HOMEM(8), FAMILIARES(9), IDOSO(
					10), PESSOAS_COM_DOENCAS_CRONICAS(12), USUARIO_DE_TABACO(13), USUARIO_DE_ALCOOL(
							14), USUARIO_DE_OUTRAS_DROGAS(15), PORTADOR_COM_SOFRIMENTO_OU_TRANSTORNO_MENTAL(
									16), PROFISSIONAL_DA_EDUCACAO(17), OUTROS(18);

	private int publicoAlvo;

	PublicoAlvo(int publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public int getPublicoAlvo() {
		return this.publicoAlvo;
	}
}
