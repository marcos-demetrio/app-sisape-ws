package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.ClassificacaoBrasileiraOcupacao;
import com.tcc.sisape.repository.ClassificacaoBrasileiraOcupacaoRepository;
import com.tcc.sisape.service.exceptions.ClassificacaoBrasileiraOcupacaoNaoEncontradoException;

@Service
public class ClassificacaoBrasileiraOcupacaoService {

	@Autowired
	private ClassificacaoBrasileiraOcupacaoRepository classificacaoBrasileiraOcupacaoRepository;

	public List<ClassificacaoBrasileiraOcupacao> findAll() {
		return classificacaoBrasileiraOcupacaoRepository.findAll();
	}

	public List<ClassificacaoBrasileiraOcupacao> findByNomeContainingOrCodigoCbo(String aNome) {
		return classificacaoBrasileiraOcupacaoRepository.findByNomeContaining(aNome);
	}

	public ClassificacaoBrasileiraOcupacao findByCodigoCbo(Long aCodigoCbo) {
		ClassificacaoBrasileiraOcupacao classificacaoBrasileiraOcupacao = classificacaoBrasileiraOcupacaoRepository
				.findByCodigoCbo(aCodigoCbo);

		if (classificacaoBrasileiraOcupacao == null) {
			throw new ClassificacaoBrasileiraOcupacaoNaoEncontradoException(
					"Classificação Brasileira de Ocupação não encontrado.");
		}

		return classificacaoBrasileiraOcupacao;
	}

	public ClassificacaoBrasileiraOcupacao findById(Long aId) {
		ClassificacaoBrasileiraOcupacao classificacaoBrasileiraOcupacao = classificacaoBrasileiraOcupacaoRepository
				.findOne(aId);

		if (classificacaoBrasileiraOcupacao == null) {
			throw new ClassificacaoBrasileiraOcupacaoNaoEncontradoException(
					"Classificação Brasileira de Ocupação não encontrado.");
		}

		return classificacaoBrasileiraOcupacao;
	}

	public void delete(Long aId) {
		try {
			classificacaoBrasileiraOcupacaoRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new ClassificacaoBrasileiraOcupacaoNaoEncontradoException(
					"Classificação Brasileira de Ocupação não encontrado.");
		}
	}

	public ClassificacaoBrasileiraOcupacao create(ClassificacaoBrasileiraOcupacao aClassificacaoBrasileiraOcupacao) {
		aClassificacaoBrasileiraOcupacao.setId(null);

		return classificacaoBrasileiraOcupacaoRepository.save(aClassificacaoBrasileiraOcupacao);
	}

	public void update(ClassificacaoBrasileiraOcupacao aClassificacaoBrasileiraOcupacao) {
		findById(aClassificacaoBrasileiraOcupacao.getId());

		classificacaoBrasileiraOcupacaoRepository.save(aClassificacaoBrasileiraOcupacao);
	}

	public List<ClassificacaoBrasileiraOcupacao> print(String aNome, Long aCodigoCbo) {
		return this.findByNomeContainingOrCodigoCbo(aNome);
	}
}
