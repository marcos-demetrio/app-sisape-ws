package com.tcc.sisape.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Atendimento;
import com.tcc.sisape.repository.AtendimentoExameRepository;
import com.tcc.sisape.repository.AtendimentoMedicamentoRepository;
import com.tcc.sisape.repository.AtendimentoRepository;
import com.tcc.sisape.repository.AtendimentoSintomaRepository;
import com.tcc.sisape.service.exceptions.AtendimentoExameNaoEncontradoException;
import com.tcc.sisape.service.exceptions.AtendimentoMedicamentoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.AtendimentoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.AtendimentoSintomaNaoEncontradoException;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private AtendimentoExameRepository atendimentoExameRepository;

	@Autowired
	private AtendimentoMedicamentoRepository atendimentoMedicamentoRepository;

	@Autowired
	private AtendimentoSintomaRepository atendimentoSintomaRepository;

	public List<Atendimento> findAll() {
		return atendimentoRepository.findAll();
	}

	public List<Atendimento> findAdoecimentoAll() {
		return atendimentoRepository.findAdoecimentoAll();
	}

	public List<Atendimento> findAdoecimentoByMunicipioId(Long aId) {
		return atendimentoRepository.findAdoecimentoByMunicipioId(aId);
	}

	public List<Atendimento> findAdoecimentoByUbsId(Long aId) {
		return atendimentoRepository.findAdoecimentoByUbsId(aId);
	}

	public List<Atendimento> findAdoecimentoByDataAtendimentoBetween(Date aDataInicio, Date aDataFinal) {
		return atendimentoRepository.findAdoecimentoByDataAtendimentoBetween(aDataInicio, aDataFinal);
	}

	public Atendimento findById(Long aId) {

		Atendimento atendimento = atendimentoRepository.findOne(aId);

		if (atendimento == null) {
			throw new AtendimentoNaoEncontradoException("Atendimento não encontrado.");
		}

		return atendimento;
	}

	public List<Atendimento> findByUnidadeBasicaSaude(Long aId) {
		List<Atendimento> atendimento = atendimentoRepository.findByUnidadeBasicaSaude(aId);

		if (atendimento == null) {
			throw new AtendimentoNaoEncontradoException("Atendimento não encontrado.");
		}

		return atendimento;
	}

	public List<Atendimento> findByProfissional(Long aId) {
		List<Atendimento> atendimento = atendimentoRepository.findByProfissional(aId);

		if (atendimento == null) {
			throw new AtendimentoNaoEncontradoException("Atendimento não encontrado.");
		}

		return atendimento;
	}

	public List<Atendimento> findByCidadao(Long aId) {
		List<Atendimento> atendimento = atendimentoRepository.findByCidadao(aId);

		if (atendimento == null) {
			throw new AtendimentoNaoEncontradoException("Atendimento não encontrado.");
		}

		return atendimento;
	}

	public List<Atendimento> findByDataAtendimentoBetween(Date aDataInicio, Date aDataFinal) {
		List<Atendimento> atendimento = atendimentoRepository.findByDataAtendimentoBetween(aDataInicio, aDataFinal);

		if (atendimento == null) {
			throw new AtendimentoNaoEncontradoException("Atendimento não encontrado.");
		}

		return atendimento;
	}

	public void delete(Long aId) {
		try {
			atendimentoRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new AtendimentoNaoEncontradoException("Atendimento não encontrado.");
		}
	}

	public Atendimento create(Atendimento aAtendimento) {
		aAtendimento.setId(null);

		return atendimentoRepository.save(aAtendimento);
	}

	public void update(Atendimento aAtendimento) {
		findById(aAtendimento.getId());

		atendimentoRepository.save(aAtendimento);
	}

	public void deletarExame(Long id) {
		try {
			atendimentoExameRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AtendimentoExameNaoEncontradoException("Atendimento Exame não encontrado.");
		}
	}

	public void deletarMedicamento(Long id) {
		try {
			atendimentoMedicamentoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AtendimentoMedicamentoNaoEncontradoException("Atendimento Medicamento não encontrado.");
		}
	}

	public void deletarSintoma(Long id) {
		try {
			atendimentoSintomaRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AtendimentoSintomaNaoEncontradoException("Atendimento Sintoma não encontrado.");
		}
	}

	public List<Atendimento> print() {
		return this.findAll();
	}

	public List<Atendimento> printByUnidadeBasicaSaude(Long aUnidadeBasicaSaude) {
		return this.findByUnidadeBasicaSaude(aUnidadeBasicaSaude);
	}

	public List<Atendimento> printByProfissional(Long aProfissional) {
		return this.findByProfissional(aProfissional);
	}

	public List<Atendimento> printByCidadao(Long aCidadao) {
		return this.findByCidadao(aCidadao);
	}

	public List<Atendimento> printByDataAtendimentoBetween(Date aDataInicio, Date aDataFinal) {
		return this.findByDataAtendimentoBetween(aDataInicio, aDataFinal);
	}

	public List<Atendimento> printAdoecimento() {
		return this.findAdoecimentoAll();
	}

	public List<Atendimento> printAdoecimentoByMunicipio(Long aMunicipio) {
		return this.findAdoecimentoByMunicipioId(aMunicipio);
	}

	public List<Atendimento> printAdoecimentoByUbs(Long aUnidadeBasicaSaude) {
		return this.findAdoecimentoByUbsId(aUnidadeBasicaSaude);
	}

	public List<Atendimento> printAdoecimentoByDataAtendimentoBetween(Date aDataInicio, Date aDataFinal) {
		return this.findAdoecimentoByDataAtendimentoBetween(aDataInicio, aDataFinal);
	}

	public Atendimento printAtestado(Long aId) {
		return this.findById(aId);
	}
	
	public Atendimento printReceita(Long aId) {
		return this.findById(aId);
	}
	
	public Atendimento printExame(Long aId) {
		return this.findById(aId);
	}
}
