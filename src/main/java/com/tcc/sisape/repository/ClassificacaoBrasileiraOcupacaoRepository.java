package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.ClassificacaoBrasileiraOcupacao;

public interface ClassificacaoBrasileiraOcupacaoRepository
		extends JpaRepository<ClassificacaoBrasileiraOcupacao, Long> {
	public List<ClassificacaoBrasileiraOcupacao> findByNomeContaining(String aNome);

	public ClassificacaoBrasileiraOcupacao findByCodigoCbo(Long aCodigoCbo);
}
