package com.tcc.sisape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Atendimento;

public interface AtendimentoMedicamentoRepository extends JpaRepository<Atendimento, Long> {

}
