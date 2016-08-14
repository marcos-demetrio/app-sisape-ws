package com.tcc.sisape.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.sisape.domain.enumdados.DiaSemana;
import com.tcc.sisape.domain.enumdados.PeriodoDia;

@Entity
public class MedicoAgenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_medico_agenda")
	@Column(name = "i_medico_agenda")
	private Long iMedicoAgenda;
		
	/*@ManyToOne(optional = false)
	@JoinColumn(name = "i_medico_parametro", referencedColumnName = "i_medico_parametro", nullable = false)
	private MedicoParametro medico;
	*/
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
