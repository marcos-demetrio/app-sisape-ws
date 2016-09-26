package com.tcc.sisape.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.sisape.domain.enumdados.DiaSemana;

@Entity
public class ProfissionalAgenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_profissional_agenda")
	@Column(name = "i_profissional_agenda")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_profissional", nullable = false)
	private Profissional profissional;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude unidadeBasicaSaude;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private DiaSemana diaSemana;

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

	public DiaSemana getDiaSemana() {
		return this.diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
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
		ProfissionalAgenda other = (ProfissionalAgenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
