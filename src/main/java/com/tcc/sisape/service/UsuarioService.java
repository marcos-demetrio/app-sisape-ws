package com.tcc.sisape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Cidadao;
import com.tcc.sisape.domain.Profissional;
import com.tcc.sisape.domain.Usuario;
import com.tcc.sisape.repository.CidadaoRepository;
import com.tcc.sisape.repository.ProfissionalRepository;
import com.tcc.sisape.service.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuarioService {

	@Autowired
	private CidadaoRepository cidadaoRepository;

	@Autowired
	private ProfissionalRepository profissionalRepository;

	public Usuario findByEmail(String aEmail) {

		Usuario usuario = null;

		Cidadao cidadao = cidadaoRepository.findByEmail(aEmail);

		if (cidadao != null) {
			usuario = new Usuario(cidadao.getId(), cidadao.getNomeCompleto(), cidadao.getEmail(), cidadao.getSenha(),
					"C");
		}

		Profissional profissional = profissionalRepository.findByEmail(aEmail);

		if (profissional != null) {
			usuario = new Usuario(profissional.getId(), profissional.getNome(), profissional.getEmail(),
					profissional.getSenha(), "P");
		}

		if (usuario == null) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}

		return usuario;
	}
}
