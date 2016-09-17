package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.UnidadeBasicaSaude;

public interface UnidadeBasicaSaudeRepository extends JpaRepository<UnidadeBasicaSaude, Long> {
	public List<UnidadeBasicaSaude> findByNomeContaining(String aNome);
}
