package com.tcc.sisape.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.ProfissionalAgenda;
import com.tcc.sisape.domain.ProfissionalLotacao;
import com.tcc.sisape.repository.ProfissionalAgendaRepository;
import com.tcc.sisape.service.exceptions.ProfissionalAgendaNaoEncontradoException;

@Service
public class ProfissionalAgendaService {

	@Autowired
	private ProfissionalAgendaRepository profissionalAgendaRepository;

	public List<ProfissionalAgenda> findAll() {
		return profissionalAgendaRepository.findAll();
	}

	public ProfissionalAgenda findById(Long id) {
		ProfissionalAgenda profissionalAgenda = profissionalAgendaRepository.findOne(id);

		if (profissionalAgenda == null) {
			throw new ProfissionalAgendaNaoEncontradoException("Agenda do Profissional não encontrada.");
		}

		return profissionalAgenda;
	}

	public Set<ProfissionalAgenda> findByLotacao(ProfissionalLotacao aLotacao) {
		Set<ProfissionalAgenda> profissionalAgenda = profissionalAgendaRepository.findByLotacao(aLotacao);

		return profissionalAgenda;
	}

	public void deletar(Long id) {
		try {
			profissionalAgendaRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProfissionalAgendaNaoEncontradoException("Agenda do Profissional não encontrada.");
		}
	}

	public ProfissionalAgenda criar(ProfissionalAgenda profissionalAgenda) {
		profissionalAgenda.setId(null);

		return profissionalAgendaRepository.save(profissionalAgenda);
	}

	public void alterar(ProfissionalAgenda profissionalAgenda) {
		findById(profissionalAgenda.getId());

		profissionalAgendaRepository.save(profissionalAgenda);
	}
}
