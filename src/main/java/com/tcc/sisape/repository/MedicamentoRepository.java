package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
	public List<Medicamento> findByNomeContaining(String aNome);
}
