package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class UnidadeBasicaSaudeTipoEstabelecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_tipo_estabelecimento")
	@Column(name = "i_tipo_estabelecimento")
	private Long iTipoEstabelecimento;
	
	@Column(length = 255, nullable = false)
	private String nome;
	
	@Column(length = 1024, nullable = false)
	private String descricao;

	public Long getiTipoEstabelecimento() {
		return this.iTipoEstabelecimento;
	}

	public void setiTipoEstabelecimento(Long iTipoEstabelecimento) {
		this.iTipoEstabelecimento = iTipoEstabelecimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		result = prime * result + ((iTipoEstabelecimento == null) ? 0 : iTipoEstabelecimento.hashCode());
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
		UnidadeBasicaSaudeTipoEstabelecimento other = (UnidadeBasicaSaudeTipoEstabelecimento) obj;
		if (iTipoEstabelecimento == null) {
			if (other.iTipoEstabelecimento != null)
				return false;
		} else if (!iTipoEstabelecimento.equals(other.iTipoEstabelecimento))
			return false;
		return true;
	}
}
