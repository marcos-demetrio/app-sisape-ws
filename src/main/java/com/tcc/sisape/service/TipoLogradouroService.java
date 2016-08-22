package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.TipoLogradouro;
import com.tcc.sisape.repository.TipoLogradouroRepository;
import com.tcc.sisape.service.exceptions.TipoLogradouroNaoEncontradoException;

@Service
public class TipoLogradouroService {

	@Autowired
	private TipoLogradouroRepository tipoLogradouroRepository;

	public List<TipoLogradouro> findAll() {
		return tipoLogradouroRepository.findAll();
	}

	public List<TipoLogradouro> findByDescricao(String aDescricao) {
		List<TipoLogradouro> listTipoLogradouro = tipoLogradouroRepository.findByDescricaoContaining(aDescricao);

		if (listTipoLogradouro.isEmpty()) {
			throw new TipoLogradouroNaoEncontradoException("Tipo de Logradouro não encontrado.");
		}

		return listTipoLogradouro;
	}

	public TipoLogradouro findById(Long aId) {
		TipoLogradouro tipoLogradouro = tipoLogradouroRepository.findOne(aId);

		if (tipoLogradouro == null) {
			throw new TipoLogradouroNaoEncontradoException("Tipo de Logradouro não encontrado.");
		}

		return tipoLogradouro;
	}

	public void delete(Long aId) {
		try {
			tipoLogradouroRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new TipoLogradouroNaoEncontradoException("Tipo de Logradouro não encontrado.");
		}
	}

	public TipoLogradouro create(TipoLogradouro aTipoLogradouro) {
		aTipoLogradouro.setId(null);

		return tipoLogradouroRepository.save(aTipoLogradouro);
	}

	public void update(TipoLogradouro aTipoLogradouro) {
		findById(aTipoLogradouro.getId());

		tipoLogradouroRepository.save(aTipoLogradouro);
	}
}
