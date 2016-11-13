package com.tcc.sisape.service;

import java.util.Date;

public class AgendamentoSenha {

	private Date horario;
	private boolean disponivel;

	public Date getHorario() {
		return this.horario;
	}

	public void setHorario(Date aHorario) {
		this.horario = aHorario;
	}

	public boolean isDisponivel() {
		return this.disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	AgendamentoSenha(Date aHorario, boolean aDisponivel) {
		this.setHorario(aHorario);
		this.setDisponivel(aDisponivel);
	}
}