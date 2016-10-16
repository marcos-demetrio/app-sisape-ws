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

import com.tcc.sisape.domain.Estado;
import com.tcc.sisape.service.EstadoService;

@CrossOrigin
@RestController
@RequestMapping("/estado")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Estado>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Estado> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.findById(aId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long aId) {
		estadoService.delete(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/nome", method = RequestMethod.GET)
	public ResponseEntity<List<Estado>> pesquisar(@RequestParam(value = "nome", defaultValue = "") String aNome) {
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.findByNome(aNome));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Estado aEstado) {
		aEstado = estadoService.create(aEstado);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aEstado.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Estado aEstado, @PathVariable("id") Long aId) {
		aEstado.setId(aId);

		estadoService.update(aEstado);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public ResponseEntity<Void> print(@RequestParam(value = "nome", defaultValue = "") String aNome) {
		try {
			estadoService.print(aNome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}
}
