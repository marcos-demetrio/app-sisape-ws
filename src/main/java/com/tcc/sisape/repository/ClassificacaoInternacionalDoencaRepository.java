package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.ClassificacaoInternacionalDoenca;

public interface ClassificacaoInternacionalDoencaRepository
		extends JpaRepository<ClassificacaoInternacionalDoenca, Long> {
	public List<ClassificacaoInternacionalDoenca> findByDescricaoContainingOrCodigoCidContaining(String aDescricao,
			String aCodigoCid);

	public ClassificacaoInternacionalDoenca findByCodigoCidContaining(String aCodigoCid);
}
