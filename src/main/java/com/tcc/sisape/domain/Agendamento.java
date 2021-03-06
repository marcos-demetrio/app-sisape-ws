package com.tcc.sisape.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Agendamento implements Serializable {

	private static final long serialVersionUID = -4190583810460463148L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_agendamento")
	@Column(name = "i_agendamento")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_cidadao", referencedColumnName = "i_cidadao", nullable = false)
	private Cidadao cidadao;

	@ManyToOne
	@JoinColumn(name = "i_profissional_lotacao", referencedColumnName = "i_profissional_lotacao")
	private ProfissionalLotacao profissionalLotacao;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataAgendamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date horaAgendamento;

	@Column(length = 1024, nullable = false)
	private String queixaPrincipal;

	@OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL)
	private List<AgendamentoSintoma> agendamentoSintoma;

	@Column(nullable = false)
	private boolean atendido;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cidadao getCidadao() {
		return this.cidadao;
	}

	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}

	public ProfissionalLotacao getProfissionalLotacao() {
		return this.profissionalLotacao;
	}

	public void setProfissionalLotacao(ProfissionalLotacao profissionalLotacao) {
		this.profissionalLotacao = profissionalLotacao;
	}

	public Date getDataAgendamento() {
		return this.dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Date getHoraAgendamento() {
		return this.horaAgendamento;
	}

	public void setHoraAgendamento(Date horaAgendamento) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(horaAgendamento);
		calendar.set(Calendar.SECOND, 0);

		this.horaAgendamento = calendar.getTime();
	}

	public String getQueixaPrincipal() {
		return this.queixaPrincipal;
	}

	public void setQueixaPrincipal(String aQueixaPrincipal) {
		this.queixaPrincipal = aQueixaPrincipal;
	}

	public List<AgendamentoSintoma> getAgendamentoSintoma() {
		return this.agendamentoSintoma;
	}

	public void setAgendamentoSintoma(List<AgendamentoSintoma> agendamentoSintoma) {
		this.agendamentoSintoma = agendamentoSintoma;
	}

	public boolean isAtendido() {
		return this.atendido;
	}

	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
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
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
