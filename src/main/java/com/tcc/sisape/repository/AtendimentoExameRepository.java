package com.tcc.sisape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Atendimento;

public interface AtendimentoExameRepository extends JpaRepository<Atendimento, Long> {

}
