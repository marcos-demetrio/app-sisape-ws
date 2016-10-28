package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ClassificacaoBrasileiraOcupacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_cbo")
	@Column(name = "i_cbo")
	private Long id;

	@Column(length = 255, nullable = false)
	private String nome;

	@Column(nullable = false)
	private Long codigoCbo;

	public Long getId() {
		return this.id;
	}

	public void setId(Long aId) {
		this.id = aId;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String aNome) {
		this.nome = aNome.toUpperCase();
	}

	public Long getCodigoCbo() {
		return this.codigoCbo;
	}

	public void setCodigoCbo(Long aCodigoCbo) {
		this.codigoCbo = aCodigoCbo;
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
		ClassificacaoBrasileiraOcupacao other = (ClassificacaoBrasileiraOcupacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
