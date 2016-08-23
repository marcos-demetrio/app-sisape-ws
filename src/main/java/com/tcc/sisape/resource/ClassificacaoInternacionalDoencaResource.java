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

import com.tcc.sisape.domain.ClassificacaoInternacionalDoenca;
import com.tcc.sisape.service.ClassificacaoInternacionalDoencaService;

@CrossOrigin
@RestController
@RequestMapping("/classificacaointernacionaldoenca")
public class ClassificacaoInternacionalDoencaResource {

	@Autowired
	private ClassificacaoInternacionalDoencaService classificacaoInternacionalDoencaService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ClassificacaoInternacionalDoenca>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(classificacaoInternacionalDoencaService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClassificacaoInternacionalDoenca> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(classificacaoInternacionalDoencaService.findById(aId));
	}

	@RequestMapping(value = "/cid/{codigoCid}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClassificacaoInternacionalDoenca> findByCodigoCid(
			@PathVariable("codigoCid") String aCodigoCid) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(classificacaoInternacionalDoencaService.findByCodigoCid(aCodigoCid));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long aId) {
		classificacaoInternacionalDoencaService.delete(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(
			@Valid @RequestBody ClassificacaoInternacionalDoenca aClassificacaoInternacionalDoenca) {
		aClassificacaoInternacionalDoenca = classificacaoInternacionalDoencaService
				.create(aClassificacaoInternacionalDoenca);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(aClassificacaoInternacionalDoenca.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ClassificacaoInternacionalDoenca aClassificacaoInternacionalDoenca,
			@PathVariable("id") Long aId) {
		aClassificacaoInternacionalDoenca.setId(aId);

		classificacaoInternacionalDoencaService.update(aClassificacaoInternacionalDoenca);

		return ResponseEntity.noContent().build();
	}
}
