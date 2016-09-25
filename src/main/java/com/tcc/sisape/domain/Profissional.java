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
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.sisape.domain.enumdados.Sexo;

@Entity
public class Profissional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_profissional")
	@Column(name = "i_profissional")
	private Long id;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 15)
	private String numeroCartaoNacionalSaude;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 11)
	private String cpf;

	@Column(length = 100, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNascimento;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Sexo sexo;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 20)
	private String telefone;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String email;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 8)
	private String cep;

	@JsonInclude(Include.NON_EMPTY)
	@ManyToOne
	@JoinColumn(name = "i_municipio", referencedColumnName = "i_municipio")
	private Municipio municipio;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String bairro;

	@JsonInclude(Include.NON_EMPTY)
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCartaoNacionalSaude() {
		return this.numeroCartaoNacionalSaude;
	}

	public void setNumeroCartaoNacionalSaude(String numeroCartaoNacionalSaude) {
		this.numeroCartaoNacionalSaude = numeroCartaoNacionalSaude;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public TipoLogradouro getTipoLogradouro() {
		return this.tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return this.numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public boolean isSemNumero() {
		return this.semNumero;
	}

	public void setSemNumero(boolean semNumero) {
		this.semNumero = semNumero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoReferencia() {
		return this.pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
