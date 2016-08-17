package com.tcc.sisape.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "i_perfil")
	private Long id;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O campo Nome é obrigatório.")
	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToMany
	@JoinTable(name = "perfil_autorizacao", joinColumns = { @JoinColumn(name = "i_perfil") }, inverseJoinColumns = {
			@JoinColumn(name = "i_autorizacao") })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();

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

	public List<Autorizacao> getAutorizacoes() {
		return this.autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
}
