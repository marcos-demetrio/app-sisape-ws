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
public class ProfissionalLotacao implements Serializable {

	private static final long serialVersionUID = -7890230304668288880L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_profissional_lotacao")
	@Column(name = "i_profissional_lotacao")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_profissional", nullable = false)
	private Profissional profissional;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude unidadeBasicaSaude;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_cbo", nullable = false)
	private ClassificacaoBrasileiraOcupacao cbo;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profissional getProfissional() {
		return this.profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public UnidadeBasicaSaude getUnidadeBasicaSaude() {
		return this.unidadeBasicaSaude;
	}

	public void setUnidadeBasicaSaude(UnidadeBasicaSaude unidadeBasicaSaude) {
		this.unidadeBasicaSaude = unidadeBasicaSaude;
	}

	public ClassificacaoBrasileiraOcupacao getCbo() {
		return this.cbo;
	}

	public void setCbo(ClassificacaoBrasileiraOcupacao cbo) {
		this.cbo = cbo;
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
		ProfissionalLotacao other = (ProfissionalLotacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
