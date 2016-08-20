package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
	public List<Pais> findByNomeContaining(String aSource);
}
