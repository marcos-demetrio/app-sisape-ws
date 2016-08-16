package com.tcc.sisape.domain.enumdados;

public enum AcessoHigiene {
	BANHO(42), ACESSO_A_SANITARIO(43), HIGIENE_BUCAL(44), OUTROS(45);

	private int acessoHigiene;

	AcessoHigiene(int acessoHigiene) {
		this.acessoHigiene = acessoHigiene;
	}

	public int getAcessoHigiene() {
		return this.acessoHigiene;
	}

}
