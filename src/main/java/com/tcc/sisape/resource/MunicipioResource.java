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

import com.tcc.sisape.domain.Municipio;
import com.tcc.sisape.service.MunicipioService;

@CrossOrigin
@RestController
@RequestMapping("/municipio")
public class MunicipioResource {

	@Autowired
	private MunicipioService municipioService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Municipio>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(municipioService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Municipio> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(municipioService.findById(aId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long aId) {
		municipioService.delete(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Municipio aMunicipio) {
		aMunicipio = municipioService.create(aMunicipio);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aMunicipio.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Municipio aMunicipio, @PathVariable("id") Long aId) {
		aMunicipio.setId(aId);

		municipioService.update(aMunicipio);

		return ResponseEntity.noContent().build();
	}
}
