package com.tcc.sisape.domain.enumdados;

public enum MaterialPredominanteNaConstrucao {
	ALVENARIA_COM_REVESTIMENTO(109), ALVENARIA_SEM_REVESTIMENTO(110), TAIPA_COM_REVESTIMENTO(
			111), TAIPA_SEM_REVESTIMENTO(
					112), MADEIRA_EMPARELHADA(113), MATERIAL_APROVEITADO(114), PALHA(115), OUTRO_MATERIAL(116);

	private int materialPredominanteNaConstrucao;

	MaterialPredominanteNaConstrucao(int materialPredominanteNaConstrucao) {
		this.materialPredominanteNaConstrucao = materialPredominanteNaConstrucao;
	}

	public int getMaterialPredominanteNaConstrucao() {
		return this.materialPredominanteNaConstrucao;
	}

}
