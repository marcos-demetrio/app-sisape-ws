package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Agendamento;
import com.tcc.sisape.domain.Cidadao;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	public List<Agendamento> findByAtendido(boolean aAtendido);
	
	public List<Agendamento> findByCidadao(Cidadao aCidadao);
}
