package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Cidadao;
import com.tcc.sisape.repository.PacientesRepository;
import com.tcc.sisape.service.exceptions.PacienteNaoEncontradoException;

@Service
public class PacientesService {

	@Autowired
	private PacientesRepository pacientesRepository;
	
	public List<Cidadao> findAll(){
		return pacientesRepository.findAll();
	}
	
	public Cidadao findByNome(String nome){
		Cidadao paciente = pacientesRepository.findByNomeContaining(nome);
		
		if(paciente == null){
			throw new PacienteNaoEncontradoException("Paciente não encontrado.");
		}
		
		return paciente;
	}
	
	public Cidadao findById(Long id){
		Cidadao paciente = pacientesRepository.findOne(id);
		
		if(paciente == null){
			throw new PacienteNaoEncontradoException("Paciente não encontrado.");
		}
		
		return paciente;
	}
	
	public void deletar(Long id){
		try {
			pacientesRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new PacienteNaoEncontradoException("Paciente não encontrado.");
		}
	}
	
	public Cidadao criar(Cidadao paciente){
		paciente.setId(null);
		
		return pacientesRepository.save(paciente);
	}
	
	public void alterar(Cidadao paciente){
		findById(paciente.getId());
		
		pacientesRepository.save(paciente);
	}
}
