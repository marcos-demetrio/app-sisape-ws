package com.tcc.sisape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Usuario;
import com.tcc.sisape.repository.UsuariosRepository;
import com.tcc.sisape.service.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public Usuario findByNome(String nome){
		Usuario usuario = usuariosRepository.findByNomeContaining(nome);
		
		if(usuario == null){
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
		
		return usuario;
	}
}
