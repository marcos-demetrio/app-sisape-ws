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

import com.tcc.sisape.domain.ClassificacaoBrasileiraOcupacao;
import com.tcc.sisape.service.ClassificacaoBrasileiraOcupacaoService;

@CrossOrigin
@RestController
@RequestMapping("/classificacaobrasileiraocupacao")
public class ClassificacaoBrasileiraOcupacaoResource {

	@Autowired
	private ClassificacaoBrasileiraOcupacaoService classificacaoBrasileiraOcupacaoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ClassificacaoBrasileiraOcupacao>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(classificacaoBrasileiraOcupacaoService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClassificacaoBrasileiraOcupacao> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(classificacaoBrasileiraOcupacaoService.findById(aId));
	}

	@RequestMapping(value = "/cbo/{codigoCbo}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClassificacaoBrasileiraOcupacao> findByCodigoCbo(@PathVariable("codigoCbo") Long aCodigoCbo) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(classificacaoBrasileiraOcupacaoService.findByCodigoCbo(aCodigoCbo));
	}

	@RequestMapping(value = "/nome", method = RequestMethod.GET)
	public ResponseEntity<List<ClassificacaoBrasileiraOcupacao>> pesquisar(
			@RequestParam(value = "codigoCbo", defaultValue = "0") Long aCodigoCbo,
			@RequestParam(value = "nome", defaultValue = "") String aNome) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(classificacaoBrasileiraOcupacaoService.findByNomeContainingOrCodigoCbo(aNome, aCodigoCbo));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long aId) {
		classificacaoBrasileiraOcupacaoService.delete(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(
			@Valid @RequestBody ClassificacaoBrasileiraOcupacao aClassificacaoBrasileiraOcupacao) {
		aClassificacaoBrasileiraOcupacao = classificacaoBrasileiraOcupacaoService
				.create(aClassificacaoBrasileiraOcupacao);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(aClassificacaoBrasileiraOcupacao.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ClassificacaoBrasileiraOcupacao aClassificacaoBrasileiraOcupacao,
			@PathVariable("id") Long aId) {
		aClassificacaoBrasileiraOcupacao.setId(aId);

		classificacaoBrasileiraOcupacaoService.update(aClassificacaoBrasileiraOcupacao);

		return ResponseEntity.noContent().build();
	}
}
