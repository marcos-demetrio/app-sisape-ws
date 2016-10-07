package com.tcc.sisape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
