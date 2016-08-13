package com.tcc.sisape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Paciente;

public interface PacientesRepository extends JpaRepository<Paciente, Long> {
	public Paciente findByNomeContaining(String nome);
}
