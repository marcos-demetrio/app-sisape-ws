package com.tcc.sisape.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProfissionalParametro implements Serializable {

	private static final long serialVersionUID = 753403245883235686L;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_profissional", nullable = false)
	private Profissional profissional;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude unidadeBasicaSaude;

	@Column(nullable = false)
	private boolean horarioMatutino = false;

	@Temporal(TemporalType.TIME)
	private Date horarioMatutinoInicio;

	@Temporal(TemporalType.TIME)
	private Date horarioMatutinoFim;

	@Column(nullable = false)
	private boolean horarioVespertino = false;

	@Temporal(TemporalType.TIME)
	private Date horarioVespertinoInicio;

	@Temporal(TemporalType.TIME)
	private Date horarioVespertinoFim;

	@Column(nullable = false)
	private boolean horarioNoturno = false;

	@Temporal(TemporalType.TIME)
	private Date horarioNoturnoInicio;

	@Temporal(TemporalType.TIME)
	private Date horarioNoturnoFim;

	@Column(nullable = false)
	private Long duracaoPadraoAtendimento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_cbo", nullable = false)
	private ClassificacaoBrasileiraOcupacao cbo;

	public boolean isHorarioMatutino() {
		return this.horarioMatutino;
	}

	public void setHorarioMatutino(boolean horarioMatutino) {
		this.horarioMatutino = horarioMatutino;
	}

	public Date getHorarioMatutinoInicio() {
		return this.horarioMatutinoInicio;
	}

	public void setHorarioMatutinoInicio(Date horarioMatutinoInicio) {
		this.horarioMatutinoInicio = horarioMatutinoInicio;
	}

	public Date getHorarioMatutinoFim() {
		return this.horarioMatutinoFim;
	}

	public void setHorarioMatutinoFim(Date horarioMatutinoFim) {
		this.horarioMatutinoFim = horarioMatutinoFim;
	}

	public boolean isHorarioVespertino() {
		return this.horarioVespertino;
	}

	public void setHorarioVespertino(boolean horarioVespertino) {
		this.horarioVespertino = horarioVespertino;
	}

	public Date getHorarioVespertinoInicio() {
		return this.horarioVespertinoInicio;
	}

	public void setHorarioVespertinoInicio(Date horarioVespertinoInicio) {
		this.horarioVespertinoInicio = horarioVespertinoInicio;
	}

	public Date getHorarioVespertinoFim() {
		return this.horarioVespertinoFim;
	}

	public void setHorarioVespertinoFim(Date horarioVespertinoFim) {
		this.horarioVespertinoFim = horarioVespertinoFim;
	}

	public boolean isHorarioNoturno() {
		return this.horarioNoturno;
	}

	public void setHorarioNoturno(boolean horarioNoturno) {
		this.horarioNoturno = horarioNoturno;
	}

	public Date getHorarioNoturnoInicio() {
		return this.horarioNoturnoInicio;
	}

	public void setHorarioNoturnoInicio(Date horarioNoturnoInicio) {
		this.horarioNoturnoInicio = horarioNoturnoInicio;
	}

	public Date getHorarioNoturnoFim() {
		return this.horarioNoturnoFim;
	}

	public void setHorarioNoturnoFim(Date horarioNoturnoFim) {
		this.horarioNoturnoFim = horarioNoturnoFim;
	}

	public Long getDuracaoPadraoAtendimento() {
		return this.duracaoPadraoAtendimento;
	}

	public void setDuracaoPadraoAtendimento(Long duracaoPadraoAtendimento) {
		this.duracaoPadraoAtendimento = duracaoPadraoAtendimento;
	}

	public ClassificacaoBrasileiraOcupacao getCbo() {
		return this.cbo;
	}

	public void setCbo(ClassificacaoBrasileiraOcupacao cbo) {
		this.cbo = cbo;
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
		result = prime * result + ((profissional == null) ? 0 : profissional.hashCode());
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
		ProfissionalParametro other = (ProfissionalParametro) obj;
		if (profissional == null) {
			if (other.profissional != null)
				return false;
		} else if (!profissional.equals(other.profissional))
			return false;
		if (unidadeBasicaSaude == null) {
			if (other.unidadeBasicaSaude != null)
				return false;
		} else if (!unidadeBasicaSaude.equals(other.unidadeBasicaSaude))
			return false;
		return true;
	}
}
