package com.tcc.sisape.service;

import java.util.ArrayList;
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

	public void print() {
		try {
			Pais p1 = new Pais();
			p1.setId(1L);
			p1.setNome("Brasil");
			p1.setSigla("BRA");

			Pais p2 = new Pais();
			p2.setId(2L);
			p2.setNome("Argentina");
			p2.setSigla("ARG");

			Pais p3 = new Pais();
			p3.setId(3L);
			p3.setNome("Alemanha");
			p3.setSigla("ALE");

			List<Pais> paises = new ArrayList<Pais>();
			paises.add(p1);
			paises.add(p2);
			paises.add(p3);

			PaisReport p = new PaisReport();
			p.imprimir(paises);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
