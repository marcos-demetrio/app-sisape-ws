package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Profissional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_profissional")
	@Column(name = "i_profissional")
	private Long id;

	@Column(length = 255, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "i_municipio")
	private Municipio municipio;
}
