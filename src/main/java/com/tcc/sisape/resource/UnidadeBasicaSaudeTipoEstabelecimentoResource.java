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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.sisape.domain.UnidadeBasicaSaudeTipoEstabelecimento;
import com.tcc.sisape.service.UnidadeBasicaSaudeTipoEstabelecimentoService;

@CrossOrigin
@RestController
@RequestMapping("/tipoestabelecimentoubs")
public class UnidadeBasicaSaudeTipoEstabelecimentoResource {

	@Autowired
	private UnidadeBasicaSaudeTipoEstabelecimentoService unidadeBasicaSaudeTipoEstabelecimentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UnidadeBasicaSaudeTipoEstabelecimento>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(unidadeBasicaSaudeTipoEstabelecimentoService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UnidadeBasicaSaudeTipoEstabelecimento> buscarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(unidadeBasicaSaudeTipoEstabelecimentoService.findById(id));
	}

	@RequestMapping(value = "/nome", method = RequestMethod.GET)
	public ResponseEntity<List<UnidadeBasicaSaudeTipoEstabelecimento>> pesquisar(
			@RequestParam(value = "nome", defaultValue = "") String aNome) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(unidadeBasicaSaudeTipoEstabelecimentoService.findByNome(aNome));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		unidadeBasicaSaudeTipoEstabelecimentoService.deletar(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody UnidadeBasicaSaudeTipoEstabelecimento unidadeBasicaSaude) {
		unidadeBasicaSaude = unidadeBasicaSaudeTipoEstabelecimentoService.criar(unidadeBasicaSaude);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(unidadeBasicaSaude.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody UnidadeBasicaSaudeTipoEstabelecimento unidadeBasicaSaude,
			@PathVariable Long id) {
		unidadeBasicaSaude.setId(id);

		unidadeBasicaSaudeTipoEstabelecimentoService.alterar(unidadeBasicaSaude);

		return ResponseEntity.noContent().build();
	}
}
