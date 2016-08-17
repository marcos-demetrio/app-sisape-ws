package com.tcc.sisape.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.sisape.domain.UnidadeBasicaSaude;
import com.tcc.sisape.service.UnidadeBasicaSaudeService;

@CrossOrigin
@RestController
@RequestMapping("/ubs")
public class UnidadeBasicaSaudeResource {

	@Autowired
	private UnidadeBasicaSaudeService unidadeBasicaSaudeService;

	@RequestMapping(method = RequestMethod.GET) // produces =
												// {MediaType.APPLICATION_JSON_VALUE,
												// MediaType.APPLICATION_XML_VALUE}
	public ResponseEntity<List<UnidadeBasicaSaude>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(unidadeBasicaSaudeService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UnidadeBasicaSaude> buscarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(unidadeBasicaSaudeService.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		unidadeBasicaSaudeService.deletar(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody UnidadeBasicaSaude unidadeBasicaSaude) {
		unidadeBasicaSaude = unidadeBasicaSaudeService.criar(unidadeBasicaSaude);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(unidadeBasicaSaude.getiUnidadeBasicaSaude()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody UnidadeBasicaSaude unidadeBasicaSaude, @PathVariable Long id) {
		unidadeBasicaSaude.setiUnidadeBasicaSaude(id);

		unidadeBasicaSaudeService.alterar(unidadeBasicaSaude);

		return ResponseEntity.noContent().build();
	}
}
