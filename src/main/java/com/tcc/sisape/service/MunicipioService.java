package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Municipio;
import com.tcc.sisape.report.MunicipioReport;
import com.tcc.sisape.repository.MunicipioRepository;
import com.tcc.sisape.service.exceptions.MunicipioNaoEncontradoException;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;

	public List<Municipio> findAll() {
		return municipioRepository.findAll();
	}

	public List<Municipio> findByNome(String aNome) {
		return municipioRepository.findByNomeContaining(aNome);
	}

	public Municipio findById(Long aId) {
		Municipio municipio = municipioRepository.findOne(aId);

		if (municipio == null) {
			throw new MunicipioNaoEncontradoException("Município não encontrado.");
		}

		return municipio;
	}

	public void delete(Long aId) {
		try {
			municipioRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new MunicipioNaoEncontradoException("Município não encontrado.");
		}
	}

	public Municipio create(Municipio aMunicipio) {
		aMunicipio.setId(null);

		return municipioRepository.save(aMunicipio);
	}

	public void update(Municipio aMunicipio) {
		findById(aMunicipio.getId());

		municipioRepository.save(aMunicipio);
	}

	public void print(String aNome) {
		try {
			MunicipioReport r = new MunicipioReport();
			r.imprimir(this.findByNome(aNome));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
