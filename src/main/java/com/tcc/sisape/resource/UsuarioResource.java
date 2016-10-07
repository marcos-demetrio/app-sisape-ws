package com.tcc.sisape.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.sisape.mail.RedefinirSenha;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@RequestMapping(value = "/novasenha", method = RequestMethod.GET)
	public ResponseEntity<Void> novaSenha(@RequestParam(value = "email", defaultValue = "") String aEmail) {

		RedefinirSenha redefinirSenha = new RedefinirSenha();
		redefinirSenha.novaSenha(aEmail);

		return ResponseEntity.noContent().build();
	}
}
