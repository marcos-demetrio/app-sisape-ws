package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Medicamento;
import com.tcc.sisape.report.MedicamentoReport;
import com.tcc.sisape.repository.MedicamentoRepository;
import com.tcc.sisape.service.exceptions.MedicamentoNaoEncontradoException;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	public List<Medicamento> findAll() {
		return medicamentoRepository.findAll();
	}

	public List<Medicamento> findByNome(String aNome) {
		return medicamentoRepository.findByNomeContaining(aNome);
	}

	public Medicamento findById(Long aId) {
		Medicamento medicamento = medicamentoRepository.findOne(aId);

		if (medicamento == null) {
			throw new MedicamentoNaoEncontradoException("Medicamento não encontrado.");
		}

		return medicamento;
	}

	public void delete(Long aId) {
		try {
			medicamentoRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new MedicamentoNaoEncontradoException("Medicamento não encontrado.");
		}
	}

	public Medicamento create(Medicamento aMedicamento) {
		aMedicamento.setId(null);

		return medicamentoRepository.save(aMedicamento);
	}

	public void update(Medicamento aMedicamento) {
		findById(aMedicamento.getId());

		medicamentoRepository.save(aMedicamento);
	}

	public void print(String aNome) {
		try {
			MedicamentoReport r = new MedicamentoReport();
			r.imprimir(this.findByNome(aNome));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
