package com.tcc.sisape.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Agendamento;
import com.tcc.sisape.domain.Cidadao;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	public List<Agendamento> findByAtendido(boolean aAtendido);

	public List<Agendamento> findByCidadao(Cidadao aCidadao);

	public List<Agendamento> findByDataAgendamento(Date aData);

	public Long countByAtendidoFalseAndCidadao(Cidadao aCidadao);
}
