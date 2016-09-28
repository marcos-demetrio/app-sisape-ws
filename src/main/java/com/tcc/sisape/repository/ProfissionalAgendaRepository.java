package com.tcc.sisape.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.ProfissionalAgenda;
import com.tcc.sisape.domain.ProfissionalLotacao;

public interface ProfissionalAgendaRepository extends JpaRepository<ProfissionalAgenda, Long> {
	public Set<ProfissionalAgenda> findByLotacao(ProfissionalLotacao aLotacao);
}
