package com.tcc.sisape.service;

import java.util.Set;

import com.tcc.sisape.domain.enumdados.PeriodoDia;

public class AgendamentoPeriodoDia {

	private PeriodoDia periodoDia;
	private Set<AgendamentoSenha> senhas;

	public PeriodoDia getPeriodoDia() {
		return this.periodoDia;
	}

	public void setPeriodoDia(PeriodoDia periodoDia) {
		this.periodoDia = periodoDia;
	}

	public Set<AgendamentoSenha> getSenhas() {
		return this.senhas;
	}

	public void setSenhas(Set<AgendamentoSenha> senhas) {
		this.senhas = senhas;
	}

	public AgendamentoPeriodoDia(PeriodoDia aPeriodoDia, Set<AgendamentoSenha> aSenhas) {
		this.setPeriodoDia(aPeriodoDia);
		this.setSenhas(aSenhas);
	}
	
	public AgendamentoPeriodoDia() {
	}

}