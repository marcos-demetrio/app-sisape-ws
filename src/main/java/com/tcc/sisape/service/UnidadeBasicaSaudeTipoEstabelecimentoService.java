package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.UnidadeBasicaSaudeTipoEstabelecimento;
import com.tcc.sisape.repository.UnidadeBasicaSaudeTipoEstabelecimentoRepository;
import com.tcc.sisape.service.exceptions.UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException;

@Service
public class UnidadeBasicaSaudeTipoEstabelecimentoService {

	@Autowired
	private UnidadeBasicaSaudeTipoEstabelecimentoRepository unidadeBasicaSaudeTipoEstabelecimentoRepository;

	public List<UnidadeBasicaSaudeTipoEstabelecimento> findAll() {
		return unidadeBasicaSaudeTipoEstabelecimentoRepository.findAll();
	}

	public List<UnidadeBasicaSaudeTipoEstabelecimento> findByNome(String aNome) {
		return unidadeBasicaSaudeTipoEstabelecimentoRepository.findByNomeContaining(aNome);
	}

	public UnidadeBasicaSaudeTipoEstabelecimento findById(Long id) {
		UnidadeBasicaSaudeTipoEstabelecimento unidadeBasicaSaudeTipoEstabelecimento = unidadeBasicaSaudeTipoEstabelecimentoRepository
				.findOne(id);

		if (unidadeBasicaSaudeTipoEstabelecimento == null) {
			throw new UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException(
					"Tipo de Estabelecimento da Unidade Básica de Saúde não encontrada.");
		}

		return unidadeBasicaSaudeTipoEstabelecimento;
	}

	public void deletar(Long id) {
		try {
			unidadeBasicaSaudeTipoEstabelecimentoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new UnidadeBasicaSaudeTipoEstabelecimentoNaoEncontradoException(
					"Tipo de Estabelecimento da Unidade Básica de Saúde não encontrado.");
		}
	}

	public UnidadeBasicaSaudeTipoEstabelecimento criar(
			UnidadeBasicaSaudeTipoEstabelecimento unidadeBasicaSaudeTipoEstabelecimento) {
		unidadeBasicaSaudeTipoEstabelecimento.setId(null);

		return unidadeBasicaSaudeTipoEstabelecimentoRepository.save(unidadeBasicaSaudeTipoEstabelecimento);
	}

	public void alterar(UnidadeBasicaSaudeTipoEstabelecimento unidadeBasicaSaudeTipoEstabelecimento) {
		findById(unidadeBasicaSaudeTipoEstabelecimento.getId());

		unidadeBasicaSaudeTipoEstabelecimentoRepository.save(unidadeBasicaSaudeTipoEstabelecimento);
	}
}
