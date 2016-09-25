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
import com.tcc.sisape.domain.enumdados.PeriodoDia;

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
	@Enumerated(EnumType.ORDINAL)
	private PeriodoDia periodoDia;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioFim;

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

	public PeriodoDia getPeriodoDia() {
		return this.periodoDia;
	}

	public void setPeriodoDia(PeriodoDia periodoDia) {
		this.periodoDia = periodoDia;
	}

	public Date getHorarioInicio() {
		return this.horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return this.horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
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
