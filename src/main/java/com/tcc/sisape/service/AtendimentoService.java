package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Atendimento;
import com.tcc.sisape.repository.AtendimentoExameRepository;
import com.tcc.sisape.repository.AtendimentoMedicamentoRepository;
import com.tcc.sisape.repository.AtendimentoRepository;
import com.tcc.sisape.repository.AtendimentoSintomaRepository;
import com.tcc.sisape.service.exceptions.AtendimentoExameNaoEncontradoException;
import com.tcc.sisape.service.exceptions.AtendimentoMedicamentoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.AtendimentoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.AtendimentoSintomaNaoEncontradoException;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;


	@Autowired
	private AtendimentoExameRepository atendimentoExameRepository;
	
	@Autowired
	private AtendimentoMedicamentoRepository atendimentoMedicamentoRepository;
	
	@Autowired
	private AtendimentoSintomaRepository atendimentoSintomaRepository;
	
	public List<Atendimento> findAll() {
		return atendimentoRepository.findAll();
	}

	public Atendimento findById(Long aId) {
		Atendimento atendimento = atendimentoRepository.findOne(aId);

		if (atendimento == null) {
			throw new AtendimentoNaoEncontradoException("Atendimento não encontrado.");
		}

		return atendimento;
	}

	public void delete(Long aId) {
		try {
			atendimentoRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new AtendimentoNaoEncontradoException("Atendimento não encontrado.");
		}
	}

	public Atendimento create(Atendimento aAtendimento) {
		aAtendimento.setId(null);

		return atendimentoRepository.save(aAtendimento);
	}

	public void update(Atendimento aAtendimento) {
		findById(aAtendimento.getId());

		atendimentoRepository.save(aAtendimento);
	}
	
	public void deletarExame(Long id) {
		try {
			atendimentoExameRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AtendimentoExameNaoEncontradoException("Atendimento Exame não encontrado.");
		}
	}

	public void deletarMedicamento(Long id) {
		try {
			atendimentoMedicamentoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AtendimentoMedicamentoNaoEncontradoException("Atendimento Medicamento não encontrado.");
		}
	}

	public void deletarSintoma(Long id) {
		try {
			atendimentoSintomaRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AtendimentoSintomaNaoEncontradoException("Atendimento Sintoma não encontrado.");
		}
	}

}