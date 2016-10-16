package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Profissional;
import com.tcc.sisape.report.ProfissionalReport;
import com.tcc.sisape.repository.ProfissionalRepository;
import com.tcc.sisape.service.exceptions.ProfissionalNaoEncontradoException;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;

	public List<Profissional> findAll() {
		return profissionalRepository.findAll();
	}

	public List<Profissional> findByNome(String aNome) {
		return profissionalRepository.findByNomeContaining(aNome);
	}

	public Profissional findById(Long id) {
		Profissional profissional = profissionalRepository.findOne(id);

		if (profissional == null) {
			throw new ProfissionalNaoEncontradoException("Profissional não encontrado.");
		}

		return profissional;
	}

	public void deletar(Long id) {
		try {
			profissionalRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProfissionalNaoEncontradoException("Profissional não encontrado.");
		}
	}

	public Profissional criar(Profissional profissional) {
		profissional.setId(null);

		return profissionalRepository.save(profissional);
	}

	public void alterar(Profissional profissional) {
		findById(profissional.getId());

		profissionalRepository.save(profissional);
	}

	public void print(String aNome) {
		try {
			ProfissionalReport r = new ProfissionalReport();
			r.imprimir(this.findByNome(aNome));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
