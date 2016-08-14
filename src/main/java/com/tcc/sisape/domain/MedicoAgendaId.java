package com.tcc.sisape.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.tcc.sisape.domain.enumdados.DiaSemana;
import com.tcc.sisape.domain.enumdados.PeriodoDia;

@Embeddable
public class MedicoAgendaId implements Serializable{

	private static final long serialVersionUID = 2664949603815082160L;
	
	@ManyToOne(optional = false)
	@JoinColumns(value = {@JoinColumn(name = "i_medico", referencedColumnName = "i_medico", nullable = false),
						  @JoinColumn(name = "i_unidade_basica_saude", referencedColumnName = "i_unidade_basica_saude", nullable = false)})
	private MedicoParametro medicoParametro;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private DiaSemana diaSemana;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private PeriodoDia periodoDia;
}
