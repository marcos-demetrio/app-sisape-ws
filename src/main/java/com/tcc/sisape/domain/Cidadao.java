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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.sisape.domain.enumdados.RacaCor;
import com.tcc.sisape.domain.enumdados.Sexo;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Cidadao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_cidadao")
	@Column(name = "i_cidadao")
	private Long id;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 15)
	private String numeroCartaoNacionalSaude;

	@Column(nullable = false)
	private boolean possuiCartaoNacionalSaude;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 11)
	private String cpf;

	@Column(length = 100, nullable = false)
	private String nomeCompleto;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String nomeSocial;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNascimento;

	@Column(nullable = false)
	private boolean faleceu;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Sexo sexo;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private RacaCor racaCor;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String nomeMae;

	@Column(nullable = false)
	private boolean desconheceNomeMae;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_municipio_nascimento", referencedColumnName = "i_municipio", nullable = false)
	private Municipio municipioNascimento;

	@Column(nullable = false)
	private boolean estrangeiro;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 8)
	private String cep;

	@ManyToOne
	@JoinColumn(name = "i_municipio", referencedColumnName = "i_municipio")
	private Municipio municipio;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "i_tipo_logradouro", referencedColumnName = "i_tipo_logradouro")
	private TipoLogradouro tipoLogradouro;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String logradouro;

	@JsonInclude(Include.NON_EMPTY)
	private Long numero;

	@Column(nullable = false)
	private boolean semNumero;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String complemento;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String pontoReferencia;

	// area
	// microArea

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 20)
	private String telefoneResidencial;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 20)
	private String telefoneCelular;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 20)
	private String telefoneContato;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String email;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 50)
	private String etnia;

	// tipoSanguineo
	// estadoCivil
	// ocupacao
	// escolaridade
	// nisPisPasep
	// numeroProntuario

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
