package com.tcc.sisape.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Estado implements Serializable {

	private static final long serialVersionUID = 5562510416323640747L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_estado")
	@Column(name = "i_estado")
	private Long id;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 2, nullable = false)
	private String sigla;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_pais", referencedColumnName = "i_pais", nullable = false)
	private Pais pais;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String aNome) {
		this.nome = aNome.toUpperCase();
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String aSigla) {
		this.sigla = aSigla.toUpperCase();
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais aPais) {
		this.pais = aPais;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
