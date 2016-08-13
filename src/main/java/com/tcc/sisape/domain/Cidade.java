package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_cidade")
	@Column(name = "i_cidade")
	private Long iCidade;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@Column(name = "sigla_uf", length = 2, nullable = false)
	private String siglaUf;

	public Long getId() {
		return this.iCidade;
	}

	public void setId(Long iCidade) {
		this.iCidade = iCidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSiglaUf() {
		return this.siglaUf;
	}

	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iCidade == null) ? 0 : iCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (iCidade == null) {
			if (other.iCidade != null)
				return false;
		} else if (!iCidade.equals(other.iCidade))
			return false;
		return true;
	}
}
