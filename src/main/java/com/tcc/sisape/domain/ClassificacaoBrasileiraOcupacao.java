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
	private Long iCbo;
	
	@Column(length = 255, nullable = false)
	private String nome;

	public Long getiCbo() {
		return this.iCbo;
	}

	public void setiCbo(Long iCbo) {
		this.iCbo = iCbo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iCbo == null) ? 0 : iCbo.hashCode());
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
		if (iCbo == null) {
			if (other.iCbo != null)
				return false;
		} else if (!iCbo.equals(other.iCbo))
			return false;
		return true;
	}
}
