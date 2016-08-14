package com.tcc.sisape.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tcc.sisape.domain.enumdados.DiaSemana;
import com.tcc.sisape.domain.enumdados.PeriodoDia;

@Entity
public class MedicoAgenda {
	
	@EmbeddedId
	private MedicoAgendaId id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private DiaSemana diaSemana;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private PeriodoDia periodoDia;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioFim;
	
}
