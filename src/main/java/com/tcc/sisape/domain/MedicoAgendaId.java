package com.tcc.sisape.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class MedicoAgendaId implements Serializable{

	private static final long serialVersionUID = 2664949603815082160L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_medico_agenda")
	@Column(name = "i_medico_agenda")
	private Long id;
		
	@ManyToOne(optional = false)
	@JoinColumns(value = {@JoinColumn(name = "i_medico", referencedColumnName = "i_medico", nullable = false),
						  @JoinColumn(name = "i_unidade_basica_saude", referencedColumnName = "i_unidade_basica_saude", nullable = false)})
	private MedicoParametro medicoParametro;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
