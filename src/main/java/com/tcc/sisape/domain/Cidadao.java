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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tcc.sisape.domain.enumdados.Sexo;

@Entity
public class Cidadao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_cidadao")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "i_cidadao")
	private Long id;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 255, nullable = false)
	private String nome;

	@CPF
	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 11, nullable = false)
	private String cpf;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private Sexo sexo;

	@Email
	@Column(length = 255, nullable = false)
	private String email;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 12)
	private String telefonePrincipal;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 12)
	private String telefoneSecundario;

	@Column(length = 8, nullable = false)
	private String cep;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_cidade", referencedColumnName = "i_cidade", nullable = false)
	private Cidade cidade;

	@Column(length = 255, nullable = false)
	private String bairro;

	@Column(length = 255, nullable = false)
	private String logradouro;

	@JsonInclude(Include.NON_EMPTY)
	private Long numero;

	@Column(nullable = false)
	private boolean semNumero;

	@Column(length = 255, nullable = false)
	private String complemento;

	@Column(length = 255, nullable = false)
	private String pontoReferencia;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonePrincipal() {
		return this.telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneSecundario() {
		return this.telefoneSecundario;
	}

	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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
		Cidadao other = (Cidadao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
