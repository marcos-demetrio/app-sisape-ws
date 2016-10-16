package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Pais;
import com.tcc.sisape.report.PaisReport;
import com.tcc.sisape.repository.PaisRepository;
import com.tcc.sisape.service.exceptions.PaisNaoEncontradoException;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;

	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	public List<Pais> findByNome(String aNome) {
		return paisRepository.findByNomeContaining(aNome);
	}

	public Pais findById(Long aId) {
		Pais pais = paisRepository.findOne(aId);

		if (pais == null) {
			throw new PaisNaoEncontradoException("País não encontrado.");
		}

		return pais;
	}

	public void delete(Long aId) {
		try {
			paisRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new PaisNaoEncontradoException("País não encontrado.");
		}
	}

	public Pais create(Pais aPais) {
		aPais.setId(null);

		return paisRepository.save(aPais);
	}

	public void update(Pais aPais) {
		findById(aPais.getId());

		paisRepository.save(aPais);
	}

	public void print(String aNome) {
		try {
			PaisReport r = new PaisReport();
			r.imprimir(this.findByNome(aNome));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
