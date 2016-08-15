package com.tcc.sisape.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class UnidadeBasicaSaudeParametroId implements Serializable{

	private static final long serialVersionUID = -6337491590480011822L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_unidade_basica_saude_parametro")
	@Column(name = "i_unidade_basica_saude_parametro")
	private Long id;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", referencedColumnName = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude unidadeBasicaSaude;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UnidadeBasicaSaude getUnidadeBasicaSaude() {
		return this.unidadeBasicaSaude;
	}

	public void setUnidadeBasicaSaude(UnidadeBasicaSaude unidadeBasicaSaude) {
		this.unidadeBasicaSaude = unidadeBasicaSaude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((unidadeBasicaSaude == null) ? 0 : unidadeBasicaSaude.hashCode());
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
		UnidadeBasicaSaudeParametroId other = (UnidadeBasicaSaudeParametroId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (unidadeBasicaSaude == null) {
			if (other.unidadeBasicaSaude != null)
				return false;
		} else if (!unidadeBasicaSaude.equals(other.unidadeBasicaSaude))
			return false;
		return true;
	}
}
