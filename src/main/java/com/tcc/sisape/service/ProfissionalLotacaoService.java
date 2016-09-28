package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.ProfissionalLotacao;
import com.tcc.sisape.repository.ProfissionalLotacaoRepository;
import com.tcc.sisape.service.exceptions.ProfissionalLotacaoNaoEncontradoException;

@Service
public class ProfissionalLotacaoService {

	@Autowired
	private ProfissionalLotacaoRepository profissionalLotacaoRepository;

	public List<ProfissionalLotacao> findAll() {
		return profissionalLotacaoRepository.findAll();
	}

	public ProfissionalLotacao findById(Long id) {
		ProfissionalLotacao profissionalLotacao = profissionalLotacaoRepository.findOne(id);

		if (profissionalLotacao == null) {
			throw new ProfissionalLotacaoNaoEncontradoException("Lotação do Profissional não encontrada.");
		}

		return profissionalLotacao;
	}

	public void deletar(Long id) {
		try {
			profissionalLotacaoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProfissionalLotacaoNaoEncontradoException("Lotação do Profissional não encontrada.");
		}
	}

	public ProfissionalLotacao criar(ProfissionalLotacao profissionalLotacao) {
		profissionalLotacao.setId(null);

		return profissionalLotacaoRepository.save(profissionalLotacao);
	}

	public void alterar(ProfissionalLotacao profissionalLotacao) {
		findById(profissionalLotacao.getId());

		profissionalLotacaoRepository.save(profissionalLotacao);
	}
}
