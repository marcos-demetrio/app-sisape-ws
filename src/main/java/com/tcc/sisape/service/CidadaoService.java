package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Cidadao;
import com.tcc.sisape.repository.CidadaoRepository;
import com.tcc.sisape.service.exceptions.CidadaoNaoEncontradoException;

@Service
public class CidadaoService {

	@Autowired
	private CidadaoRepository cidadaoRepository;

	public List<Cidadao> findAll() {
		return cidadaoRepository.findAll();
	}

	public List<Cidadao> findByNome(String aNome) {
		return cidadaoRepository.findByNomeCompletoContaining(aNome);
	}

	public Cidadao findById(Long id) {
		Cidadao paciente = cidadaoRepository.findOne(id);

		if (paciente == null) {
			throw new CidadaoNaoEncontradoException("Cidadão não encontrado.");
		}

		return paciente;
	}

	public void deletar(Long id) {
		try {
			cidadaoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new CidadaoNaoEncontradoException("Cidadão não encontrado.");
		}
	}

	public Cidadao criar(Cidadao cidadao) {
		cidadao.setId(null);

		return cidadaoRepository.save(cidadao);
	}

	public void alterar(Cidadao cidadao) {
		findById(cidadao.getId());

		cidadaoRepository.save(cidadao);
	}
}
