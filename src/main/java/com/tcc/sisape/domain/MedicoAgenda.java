package com.tcc.sisape.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MedicoAgenda {
	
	@EmbeddedId
	private MedicoAgendaId id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioFim;
	
}
