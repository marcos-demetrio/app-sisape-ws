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

import com.tcc.sisape.domain.Cidadao;
import com.tcc.sisape.domain.Profissional;
import com.tcc.sisape.domain.Usuario;
import com.tcc.sisape.mail.RedefinirSenha;
import com.tcc.sisape.seguranca.Criptografia;
import com.tcc.sisape.service.CidadaoService;
import com.tcc.sisape.service.ProfissionalService;
import com.tcc.sisape.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private CidadaoService cidadaoService;

	@Autowired
	private ProfissionalService profissionalService;

	@RequestMapping(value = "/novasenha", method = RequestMethod.GET)
	public ResponseEntity<String> novaSenha(@RequestParam(value = "email", defaultValue = "") String aEmail) {
		Usuario user = usuarioService.findByEmail(aEmail);

		if (user != null) {

			String senha = new RedefinirSenha().novaSenha(aEmail);

			switch (user.getTipoUsuario()) {
			case "C":
				Cidadao cidadao = cidadaoService.findById(user.getId());
				cidadao.setSenha(Criptografia.md5(senha));

				cidadaoService.alterar(cidadao);
				break;

			default:
				Profissional profissional = profissionalService.findById(user.getId());
				profissional.setSenha(Criptografia.md5(senha));

				profissionalService.alterar(profissional);
				break;
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body("Ok");
	}

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Usuario> pesquisar(@RequestParam(value = "email", defaultValue = "") String aEmail) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findByEmail(aEmail));
	}
}
