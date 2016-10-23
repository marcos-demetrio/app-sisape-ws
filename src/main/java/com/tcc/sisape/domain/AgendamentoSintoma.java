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
public class AgendamentoSintoma implements Serializable {

	private static final long serialVersionUID = 3078924929266968807L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_sequencial")
	@Column(name = "i_sequencial")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_agendamento", referencedColumnName = "i_agendamento", nullable = false)
	private Agendamento agendamento;

	@ManyToOne
	@JoinColumn(name = "i_cid", referencedColumnName = "i_cid")
	private ClassificacaoInternacionalDoenca cid;

	@Column(length = 255)
	private String descricao;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public ClassificacaoInternacionalDoenca getCid() {
		return this.cid;
	}

	public void setCid(ClassificacaoInternacionalDoenca cid) {
		this.cid = cid;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		AgendamentoSintoma other = (AgendamentoSintoma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
