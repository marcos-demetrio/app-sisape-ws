package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Autorizacao /*implements GrantedAuthority*/{
	
	//private static final long serialVersionUID = -6655857239714408341L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "i_autorizacao")
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O campo Senha é obrigatório.")
	@Column(length = 50, nullable = false)
	private String nome;
	/*
	@Override
	public String getAuthority(){
		return this.nome;
	}*/
}
