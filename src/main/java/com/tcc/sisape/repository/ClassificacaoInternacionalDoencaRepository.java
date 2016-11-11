package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.ClassificacaoInternacionalDoenca;

public interface ClassificacaoInternacionalDoencaRepository
		extends JpaRepository<ClassificacaoInternacionalDoenca, Long> {
	public List<ClassificacaoInternacionalDoenca> findByDescricaoContaining(String aDescricao);

	public ClassificacaoInternacionalDoenca findByCodigoCidContaining(String aCodigoCid);
}
