package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Exame;
import com.tcc.sisape.report.ExameReport;
import com.tcc.sisape.repository.ExameRepository;
import com.tcc.sisape.service.exceptions.ExameNaoEncontradoException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository exameRepository;

	public List<Exame> findAll() {
		return exameRepository.findAll();
	}

	public List<Exame> findByNome(String aNome) {
		return exameRepository.findByNomeContaining(aNome);
	}

	public Exame findById(Long aId) {
		Exame exame = exameRepository.findOne(aId);

		if (exame == null) {
			throw new ExameNaoEncontradoException("Exame não encontrado.");
		}

		return exame;
	}

	public void delete(Long aId) {
		try {
			exameRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new ExameNaoEncontradoException("Exame não encontrado.");
		}
	}

	public Exame create(Exame aExame) {
		aExame.setId(null);

		return exameRepository.save(aExame);
	}

	public void update(Exame aExame) {
		findById(aExame.getId());

		exameRepository.save(aExame);
	}

	public void print(String aNome) {
		try {
			ExameReport r = new ExameReport();
			r.imprimir(this.findByNome(aNome));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
