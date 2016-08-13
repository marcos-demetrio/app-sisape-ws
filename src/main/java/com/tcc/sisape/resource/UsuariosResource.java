package com.tcc.sisape.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.sisape.domain.Usuario;
import com.tcc.sisape.service.UsuariosService;

@RestController
@RequestMapping("/usuario")
public class UsuariosResource {
	
	@Autowired
	private UsuariosService usuariosService;

	@RequestMapping(value = "/{nome}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Usuario> findByNome(@PathVariable("nome") String nome){
		return ResponseEntity.status(HttpStatus.OK).body(usuariosService.findByNome(nome));
	}
	
}
