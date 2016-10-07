package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Agendamento;
import com.tcc.sisape.repository.AgendamentoRepository;
import com.tcc.sisape.service.exceptions.AgendamentoNaoEncontradoException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
	}

	public Agendamento findById(Long aId) {
		Agendamento agendamento = agendamentoRepository.findOne(aId);

		if (agendamento == null) {
			throw new AgendamentoNaoEncontradoException("Agendamento não encontrado.");
		}

		return agendamento;
	}

	public void delete(Long aId) {
		try {
			agendamentoRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new AgendamentoNaoEncontradoException("Agendamento não encontrado.");
		}
	}

	public Agendamento create(Agendamento aAgendamento) {
		aAgendamento.setId(null);

		return agendamentoRepository.save(aAgendamento);
	}

	public void update(Agendamento aAgendamento) {
		findById(aAgendamento.getId());

		agendamentoRepository.save(aAgendamento);
	}
}
