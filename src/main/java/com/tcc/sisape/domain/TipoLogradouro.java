package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TipoLogradouro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_tipo_logradouro")
	@Column(name = "i_tipo_logradouro")
	private Long id;

	@Column(length = 50, nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Long codigoEsus;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigoEsus() {
		return this.codigoEsus;
	}

	public void setCodigoEsus(Long codigoEsus) {
		this.codigoEsus = codigoEsus;
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
		TipoLogradouro other = (TipoLogradouro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
