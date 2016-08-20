package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	public List<Estado> findByNomeContaining(String aNome);
}
