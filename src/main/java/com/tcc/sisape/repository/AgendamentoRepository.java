package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	public List<Agendamento> findByAtendido(boolean aAtendido);
}
