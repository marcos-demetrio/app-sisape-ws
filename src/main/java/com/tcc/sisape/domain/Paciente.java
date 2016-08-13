package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_paciente")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "i_paciente")
	private Long id;
	
	@JsonInclude(Include.NON_EMPTY)
	@NotEmpty(message = "O campo Nome é obrigatório.")
	@Column(length = 255, nullable = false)
	private String nome;
	
	@JsonInclude(Include.NON_EMPTY)
	@NotEmpty(message = "O campo CPF é obrigatório.")
	@Column(length = 11, nullable = false)
	private String cpf;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_cidade", referencedColumnName = "i_cidade", nullable = false)
	private Cidade cidade;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Cidade getCidade() {
		return this.cidade;
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
