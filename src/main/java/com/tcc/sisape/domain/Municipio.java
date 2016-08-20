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
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_municipio")
	@Column(name = "i_municipio")
	private Long id;

	@Column(nullable = false)
	private Long codigoIbge;

	@Column(length = 100, nullable = false)
	private String nome;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_estado", referencedColumnName = "i_estado", nullable = false)
	private Estado estado;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodigoIbge() {
		return this.codigoIbge;
	}

	public void setCodigoIbge(Long codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoIbge == null) ? 0 : codigoIbge.hashCode());
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
		Municipio other = (Municipio) obj;
		if (codigoIbge == null) {
			if (other.codigoIbge != null)
				return false;
		} else if (!codigoIbge.equals(other.codigoIbge))
			return false;
		return true;
	}
}
