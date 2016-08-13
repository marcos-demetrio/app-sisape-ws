package com.tcc.sisape.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class MedicoParametro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_medico_parametro")
	@Column(name = "i_medico_parametro")
	private Long iMedicoParametro;
	
	@Column(nullable = false)
	private boolean horarioMatutino;
	
	@Temporal(TemporalType.TIME)
	private Date horarioMatutinoInicio;
	
	@Temporal(TemporalType.TIME)
	private Date horarioMatutinoFim;
	
	@Column(nullable = false)
	private boolean horarioVespertino;
	
	@Temporal(TemporalType.TIME)
	private Date horarioVespertinoInicio;
	
	@Temporal(TemporalType.TIME)
	private Date horarioVespertinoFim;
	
	@Column(nullable = false)
	private boolean horarioNoturno;
	
	@Temporal(TemporalType.TIME)
	private Date horarioNoturnoInicio;
	
	@Temporal(TemporalType.TIME)
	private Date horarioNoturnoFim;
	
	@Column(nullable = false)
	private Long duracaoPadraoAtendimento;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_cbo", referencedColumnName = "i_cbo", nullable = false)
	private ClassificacaoBrasileiraOcupacao cbo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_medico", referencedColumnName = "i_medico", nullable = false)
	private Medico medico;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", referencedColumnName = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude ubs;

	public Long getiMedicoParametro() {
		return this.iMedicoParametro;
	}

	public void setiMedicoParametro(Long iMedicoParametro) {
		this.iMedicoParametro = iMedicoParametro;
	}

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

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public UnidadeBasicaSaude getUbs() {
		return this.ubs;
	}

	public void setUbs(UnidadeBasicaSaude ubs) {
		this.ubs = ubs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cbo == null) ? 0 : cbo.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((ubs == null) ? 0 : ubs.hashCode());
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
		MedicoParametro other = (MedicoParametro) obj;
		if (cbo == null) {
			if (other.cbo != null)
				return false;
		} else if (!cbo.equals(other.cbo))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (ubs == null) {
			if (other.ubs != null)
				return false;
		} else if (!ubs.equals(other.ubs))
			return false;
		return true;
	}
}
