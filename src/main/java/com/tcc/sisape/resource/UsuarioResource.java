package com.tcc.sisape.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.sisape.domain.Usuario;
import com.tcc.sisape.mail.RedefinirSenha;
import com.tcc.sisape.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/novasenha", method = RequestMethod.GET)
	public ResponseEntity<Void> novaSenha(@RequestParam(value = "email", defaultValue = "") String aEmail) {

		RedefinirSenha redefinirSenha = new RedefinirSenha();
		redefinirSenha.novaSenha(aEmail);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Usuario> pesquisar(@RequestParam(value = "email", defaultValue = "") String aEmail) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findByEmail(aEmail));
	}
}
