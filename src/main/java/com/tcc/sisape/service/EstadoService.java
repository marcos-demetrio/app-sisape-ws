package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Estado;
import com.tcc.sisape.repository.EstadoRepository;
import com.tcc.sisape.service.exceptions.EstadoNaoEncontradoException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	public List<Estado> findByNome(String aNome) {
		return estadoRepository.findByNomeContaining(aNome);
	}

	public Estado findById(Long aId) {
		Estado estado = estadoRepository.findOne(aId);

		if (estado == null) {
			throw new EstadoNaoEncontradoException("Estado não encontrado.");
		}

		return estado;
	}

	public void delete(Long aId) {
		try {
			estadoRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException("Estado não encontrado.");
		}
	}

	public Estado create(Estado aEstado) {
		aEstado.setId(null);

		return estadoRepository.save(aEstado);
	}

	public void update(Estado aEstado) {
		findById(aEstado.getId());

		estadoRepository.save(aEstado);
	}

	public List<Estado> print(String aNome) {
		return this.findByNome(aNome);
	}
}
