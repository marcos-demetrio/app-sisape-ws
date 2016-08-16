package com.tcc.sisape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Cidadao;

public interface PacientesRepository extends JpaRepository<Cidadao, Long> {
	public Cidadao findByNomeContaining(String nome);
}
