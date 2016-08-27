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
public class Usuario /* implements UserDetails */ {

	private static final long serialVersionUID = -5907543812944327336L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "i_usuario")
	private Long id;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O campo Nome é obrigatório.")
	@Column(length = 20, nullable = false)
	private String nome;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O campo Senha é obrigatório.")
	@Column(length = 50, nullable = false)
	private String senha;

	@ManyToMany
	@JoinTable(name = "uruario_perfil", joinColumns = { @JoinColumn(name = "i_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "i_perfil") })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Perfil> perfis = new ArrayList<Perfil>();

	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities(){
	 * Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();
	 * 
	 * if(perfis != null){ for (Perfil perfil : perfis) {
	 * autorizacoes.addAll(perfil.getAutorizacoes()); } } return autorizacoes; }
	 */
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @Override
	public String getUsername() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// @Override
	public String getPassword() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// @Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// @Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// @Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// @Override
	public boolean isEnabled() {
		return true;
	}
}
