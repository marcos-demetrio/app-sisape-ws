package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.TipoLogradouro;

public interface TipoLogradouroRepository extends JpaRepository<TipoLogradouro, Long> {
	public List<TipoLogradouro> findByDescricaoContaining(String aDescricao);
}
