package com.tcc.sisape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.UnidadeBasicaSaude;

public interface UnidadeBasicaSaudeRepository extends JpaRepository<UnidadeBasicaSaude, Long> {
	public UnidadeBasicaSaude findByNomeContaining(String nome);
}
