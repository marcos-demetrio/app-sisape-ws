package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	public List<Municipio> findByNomeContaining(String aNome);
}
