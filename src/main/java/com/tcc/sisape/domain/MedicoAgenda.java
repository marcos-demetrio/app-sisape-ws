package com.tcc.sisape.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tcc.sisape.domain.enumdados.DiaSemana;
import com.tcc.sisape.domain.enumdados.PeriodoDia;

@Entity
public class MedicoAgenda implements Serializable{
	
	private static final long serialVersionUID = -1149180357096558979L;

	@Id
	@ManyToOne(optional = false)
	@JoinColumns(value = {@JoinColumn(name = "i_medico", referencedColumnName = "i_medico", nullable = false),
						  @JoinColumn(name = "i_unidade_basica_saude", referencedColumnName = "i_unidade_basica_saude", nullable = false)})
	private MedicoParametro medicoParametro;

	@Id
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private DiaSemana diaSemana;
	
	@Id
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
