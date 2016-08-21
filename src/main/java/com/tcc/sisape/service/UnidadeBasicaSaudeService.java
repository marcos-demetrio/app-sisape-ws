package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.UnidadeBasicaSaude;
import com.tcc.sisape.repository.UnidadeBasicaSaudeRepository;
import com.tcc.sisape.service.exceptions.UnidadeBasicaSaudeNaoEncontradoException;

@Service
public class UnidadeBasicaSaudeService {

	@Autowired
	private UnidadeBasicaSaudeRepository unidadeBasicaSaudeRepository;

	public List<UnidadeBasicaSaude> findAll() {
		return unidadeBasicaSaudeRepository.findAll();
	}

	public UnidadeBasicaSaude findByNome(String nome) {
		UnidadeBasicaSaude unidadeBasicaSaude = unidadeBasicaSaudeRepository.findByNomeContaining(nome);

		if (unidadeBasicaSaude == null) {
			throw new UnidadeBasicaSaudeNaoEncontradoException("Unidade Básica de Saúde não encontrada.");
		}

		return unidadeBasicaSaude;
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

	public UnidadeBasicaSaude criar(UnidadeBasicaSaude unidadeBasicaSaude) {
		unidadeBasicaSaude.setId(null);

		return unidadeBasicaSaudeRepository.save(unidadeBasicaSaude);
	}

	public void alterar(UnidadeBasicaSaude unidadeBasicaSaude) {
		findById(unidadeBasicaSaude.getId());

		unidadeBasicaSaudeRepository.save(unidadeBasicaSaude);
	}
}
