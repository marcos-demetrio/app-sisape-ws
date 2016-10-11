package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
	public List<Profissional> findByNomeContaining(String aNome);

	public Profissional findByEmail(String aEmail);
}
