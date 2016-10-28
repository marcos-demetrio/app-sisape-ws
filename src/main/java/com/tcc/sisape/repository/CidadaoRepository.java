package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Cidadao;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {
	public List<Cidadao> findByNomeCompletoContaining(String aNome);

	public Cidadao findByEmail(String aEmail);
}
