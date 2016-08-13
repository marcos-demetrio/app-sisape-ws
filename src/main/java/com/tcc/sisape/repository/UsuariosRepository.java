package com.tcc.sisape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.sisape.domain.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
	public Usuario findByNomeContaining(String nome);
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
