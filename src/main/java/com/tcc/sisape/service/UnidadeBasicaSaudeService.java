package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.UnidadeBasicaSaude;
import com.tcc.sisape.repository.UnidadeBasicaSaudeRepository;
import com.tcc.sisape.repository.UnidadeBasicaSaudeZonaAtendimentoRepository;
import com.tcc.sisape.service.exceptions.UnidadeBasicaSaudeNaoEncontradoException;
import com.tcc.sisape.service.exceptions.UnidadeBasicaSaudeZonaAtendimentoNaoEncontradoException;

@Service
public class UnidadeBasicaSaudeService {

	@Autowired
	private UnidadeBasicaSaudeRepository unidadeBasicaSaudeRepository;

	@Autowired
	private UnidadeBasicaSaudeZonaAtendimentoRepository unidadeBasicaSaudeZonaAtendimentoRepository;

	public List<UnidadeBasicaSaude> findAll() {
		return unidadeBasicaSaudeRepository.findAll();
	}

	public List<UnidadeBasicaSaude> findByNome(String aNome) {
		return unidadeBasicaSaudeRepository.findByNomeContaining(aNome);
	}

	public UnidadeBasicaSaude findById(Long id) {
		UnidadeBasicaSaude unidadeBasicaSaude = unidadeBasicaSaudeRepository.findOne(id);

		if (unidadeBasicaSaude == null) {
			throw new UnidadeBasicaSaudeNaoEncontradoException("Unidade Básica de Saúde não encontrada.");
		}

		return unidadeBasicaSaude;
	}

	public void deletar(Long id) {
		try {
			unidadeBasicaSaudeRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new UnidadeBasicaSaudeNaoEncontradoException("Unidade Básica de Saúde não encontrado.");
		}
	}

	public void deletarZonaAtendimento(Long id) {
		try {
			unidadeBasicaSaudeZonaAtendimentoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new UnidadeBasicaSaudeZonaAtendimentoNaoEncontradoException(
					"Zona de Atendimento da Unidade Básica de Saúde não encontrado.");
		}
	}

	public UnidadeBasicaSaude criar(UnidadeBasicaSaude unidadeBasicaSaude) {
		unidadeBasicaSaude.setId(null);

		return unidadeBasicaSaudeRepository.save(unidadeBasicaSaude);
	}

	public void alterar(UnidadeBasicaSaude unidadeBasicaSaude) {
		findById(unidadeBasicaSaude.getId());

		unidadeBasicaSaudeRepository.save(unidadeBasicaSaude);
	}

	public List<UnidadeBasicaSaude> print(String aNome) {
		return this.findByNome(aNome);
	}
}
