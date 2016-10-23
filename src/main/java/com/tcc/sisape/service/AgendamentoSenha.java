package com.tcc.sisape.service;

import java.util.Date;

public class AgendamentoSenha {

	private Date horario;
	private int numero;
	private boolean disponivel;

	public Date getHorario() {
		return this.horario;
	}

	public void setHorario(Date aHorario) {
		this.horario = aHorario;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int aNumero) {
		this.numero = aNumero;
	}

	public boolean isDisponivel() {
		return this.disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	AgendamentoSenha(Date aHorario, int aNumero, boolean aDisponivel) {
		this.setHorario(aHorario);
		this.setNumero(aNumero);
		this.setDisponivel(aDisponivel);
	}
}