package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {
	public List<Exame> findByNomeContaining(String aNome);
}
