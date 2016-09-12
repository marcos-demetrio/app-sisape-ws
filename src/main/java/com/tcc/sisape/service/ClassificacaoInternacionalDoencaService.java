package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.ClassificacaoInternacionalDoenca;
import com.tcc.sisape.repository.ClassificacaoInternacionalDoencaRepository;
import com.tcc.sisape.service.exceptions.ClassificacaoInternacionalDoencaNaoEncontradoException;

@Service
public class ClassificacaoInternacionalDoencaService {

	@Autowired
	private ClassificacaoInternacionalDoencaRepository classificacaoInternacionalDoencaRepository;

	public List<ClassificacaoInternacionalDoenca> findAll() {
		return classificacaoInternacionalDoencaRepository.findAll();
	}

	public List<ClassificacaoInternacionalDoenca> findByDescricaoContainingOrCodigoCidContaining(String aDescricao, String aCodigoCid) {
		return classificacaoInternacionalDoencaRepository.findByDescricaoContainingOrCodigoCidContaining(aDescricao,
				aCodigoCid);
	}

	public ClassificacaoInternacionalDoenca findByCodigoCid(String aCodigoCid) {
		ClassificacaoInternacionalDoenca classificacaoInternacionalDoenca = classificacaoInternacionalDoencaRepository
				.findByCodigoCidContaining(aCodigoCid);

		if (classificacaoInternacionalDoenca == null) {
			throw new ClassificacaoInternacionalDoencaNaoEncontradoException(
					"Classificação Internacional de Doença não encontrado.");
		}

		return classificacaoInternacionalDoenca;
	}

	public ClassificacaoInternacionalDoenca findById(Long aId) {
		ClassificacaoInternacionalDoenca classificacaoInternacionalDoenca = classificacaoInternacionalDoencaRepository
				.findOne(aId);

		if (classificacaoInternacionalDoenca == null) {
			throw new ClassificacaoInternacionalDoencaNaoEncontradoException(
					"Classificação Internacional de Doença não encontrado.");
		}

		return classificacaoInternacionalDoenca;
	}

	public void delete(Long aId) {
		try {
			classificacaoInternacionalDoencaRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new ClassificacaoInternacionalDoencaNaoEncontradoException(
					"Classificação Internacional de Doença não encontrado.");
		}
	}

	public ClassificacaoInternacionalDoenca create(ClassificacaoInternacionalDoenca aClassificacaoInternacionalDoenca) {
		aClassificacaoInternacionalDoenca.setId(null);

		return classificacaoInternacionalDoencaRepository.save(aClassificacaoInternacionalDoenca);
	}

	public void update(ClassificacaoInternacionalDoenca aClassificacaoInternacionalDoenca) {
		findById(aClassificacaoInternacionalDoenca.getId());

		classificacaoInternacionalDoencaRepository.save(aClassificacaoInternacionalDoenca);
	}
}
