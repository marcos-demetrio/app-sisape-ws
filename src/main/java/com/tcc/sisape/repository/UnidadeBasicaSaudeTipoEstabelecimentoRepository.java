package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.UnidadeBasicaSaudeTipoEstabelecimento;

public interface UnidadeBasicaSaudeTipoEstabelecimentoRepository
		extends JpaRepository<UnidadeBasicaSaudeTipoEstabelecimento, Long> {
	public List<UnidadeBasicaSaudeTipoEstabelecimento> findByNomeContaining(String aNome);
}
