package com.tcc.sisape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Paciente;
import com.tcc.sisape.repository.PacientesRepository;
import com.tcc.sisape.service.exceptions.PacienteNaoEncontradoException;

@Service
public class PacientesService {

	@Autowired
	private PacientesRepository pacientesRepository;
	
	public List<Paciente> findAll(){
		return pacientesRepository.findAll();
	}
	
	public Paciente findByNome(String nome){
		Paciente paciente = pacientesRepository.findByNomeContaining(nome);
		
		if(paciente == null){
			throw new PacienteNaoEncontradoException("Paciente não encontrado.");
		}
		
		return paciente;
	}
	
	public Paciente findById(Long id){
		Paciente paciente = pacientesRepository.findOne(id);
		
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
	
	public Paciente criar(Paciente paciente){
		paciente.setId(null);
		
		return pacientesRepository.save(paciente);
	}
	
	public void alterar(Paciente paciente){
		findById(paciente.getId());
		
		pacientesRepository.save(paciente);
	}
}
