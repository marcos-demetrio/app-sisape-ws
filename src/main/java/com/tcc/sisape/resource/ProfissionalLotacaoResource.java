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

import com.tcc.sisape.domain.ProfissionalLotacao;
import com.tcc.sisape.service.ProfissionalLotacaoService;

@CrossOrigin
@RestController
@RequestMapping("/lotacao")
public class ProfissionalLotacaoResource {

	@Autowired
	private ProfissionalLotacaoService profissionalLotacaoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProfissionalLotacao>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(profissionalLotacaoService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProfissionalLotacao> buscarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(profissionalLotacaoService.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		profissionalLotacaoService.deletar(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody ProfissionalLotacao profissionalLotacao) {
		profissionalLotacao = profissionalLotacaoService.criar(profissionalLotacao);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profissionalLotacao.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody ProfissionalLotacao profissionalLotacao, @PathVariable Long id) {
		profissionalLotacao.setId(id);

		profissionalLotacaoService.alterar(profissionalLotacao);

		return ResponseEntity.noContent().build();
	}
}
