package com.tcc.sisape.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MedicoParametroId implements Serializable{

	private static final long serialVersionUID = -6835174482820268734L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_medico", referencedColumnName = "i_medico", nullable = false)
	private Medico medico;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", referencedColumnName = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude unidadeBasicaSaude;

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
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
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
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
		MedicoParametroId other = (MedicoParametroId) obj;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (unidadeBasicaSaude == null) {
			if (other.unidadeBasicaSaude != null)
				return false;
		} else if (!unidadeBasicaSaude.equals(other.unidadeBasicaSaude))
			return false;
		return true;
	}
}
