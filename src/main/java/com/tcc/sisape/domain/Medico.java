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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tcc.sisape.domain.enumdados.Sexo;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_medico")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "i_medico")
	private Long id;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 255, nullable = false)
	private String nome;
	
	@CPF
	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 11, nullable = false)
	private String cpf;
	
	//private String cns;//duvida
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING)//, columnDefinition = "char(1) default 'M'"
	@Column(length = 1, nullable = false)
	private Sexo sexo;
	
	//private String conselhoClasse;//duvida
	//private String orgaoEmissor;//duvida
	//private String registroConselhoClasse;//duvida
	
	@Email
	@Column(length = 255, nullable = false)
	private String email;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 12)
	private String telefonePrincipal;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 12)
	private String telefoneSecundario;
	
	@Column(length = 8, nullable = false)
	private String cep;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_cidade", referencedColumnName = "i_cidade", nullable = false)
	private Cidade cidade;

	@Column(length = 255, nullable = false)
	private String bairro;
	
	@Column(length = 255, nullable = false)
	private String logradouro;
	
	@JsonInclude(Include.NON_EMPTY)
	private Long numero;

	@Column(nullable = false)
	private boolean semNumero;
	
	@Column(length = 255, nullable = false)
	private String complemento;
	
	@Column(length = 255, nullable = false)
	private String pontoReferencia;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
