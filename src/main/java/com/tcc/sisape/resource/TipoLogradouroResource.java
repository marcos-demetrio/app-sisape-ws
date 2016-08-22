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

import com.tcc.sisape.domain.TipoLogradouro;
import com.tcc.sisape.service.TipoLogradouroService;

@CrossOrigin
@RestController
@RequestMapping("/tipologradouro")
public class TipoLogradouroResource {

	@Autowired
	private TipoLogradouroService tipoLogradouroService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<TipoLogradouro>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(tipoLogradouroService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TipoLogradouro> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(tipoLogradouroService.findById(aId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long aId) {
		tipoLogradouroService.delete(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody TipoLogradouro aTipoLogradouro) {
		aTipoLogradouro = tipoLogradouroService.create(aTipoLogradouro);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aTipoLogradouro.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody TipoLogradouro aTipoLogradouro, @PathVariable("id") Long aId) {
		aTipoLogradouro.setId(aId);

		tipoLogradouroService.update(aTipoLogradouro);

		return ResponseEntity.noContent().build();
	}
}
