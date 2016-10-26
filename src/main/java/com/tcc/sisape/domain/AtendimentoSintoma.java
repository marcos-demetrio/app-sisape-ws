package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AtendimentoSintoma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_sequencial")
	@Column(name = "i_sequencial")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_atendimento", referencedColumnName = "i_atendimento", nullable = false)
	private Atendimento atendimento;

	@ManyToOne
	@JoinColumn(name = "i_cid", referencedColumnName = "i_cid")
	private ClassificacaoInternacionalDoenca cid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public ClassificacaoInternacionalDoenca getCid() {
		return cid;
	}

	public void setCid(ClassificacaoInternacionalDoenca cid) {
		this.cid = cid;
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
		AtendimentoSintoma other = (AtendimentoSintoma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
