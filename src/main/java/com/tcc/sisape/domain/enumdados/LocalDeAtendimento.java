package com.tcc.sisape.domain.enumdados;

public enum LocalDeAtendimento {
	UBS(1), UNIDADE_MOVEL(2), RUA(3), DOMICILIO(4), ESCOLA_CRECHE(5), OUTROS(6), POLO_ACADEMIA_DA_SAUDE(
			7), INSTITUICAO_ABRIGO(8), UNIDADE_PRISIONAL_OU_CONGENERES(9), UNIDADE_SOCIOEDUCATIVA(
					10), HOSPITAL(11), UNIDADE_DE_PRONTO_ATENDIMENTO(
							12), CACON_UNACON(13), HOSPITAL_SOS_URGENCIA(14), HOSPITAL_SOS_DEMAIS_SETORES(15);

	private int localDeAtendimento;

	LocalDeAtendimento(int localDeAtendimento) {
		this.localDeAtendimento = localDeAtendimento;
	}

	public int getLocalDeAtendimento() {
		return this.localDeAtendimento;
	}

}
