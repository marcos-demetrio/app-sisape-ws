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

import com.tcc.sisape.domain.Medicamento;
import com.tcc.sisape.service.MedicamentoService;

@CrossOrigin
@RestController
@RequestMapping("/medicamento")
public class MedicamentoResource {

	@Autowired
	private MedicamentoService medicamentoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Medicamento>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Medicamento> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.findById(aId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long aId) {
		medicamentoService.delete(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/nome", method = RequestMethod.GET)
	public ResponseEntity<List<Medicamento>> pesquisar(@RequestParam(value = "nome", defaultValue = "") String aNome) {
		return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.findByNome(aNome));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Medicamento aMedicamento) {
		aMedicamento = medicamentoService.create(aMedicamento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aMedicamento.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Medicamento aMedicamento, @PathVariable("id") Long aId) {
		aMedicamento.setId(aId);

		medicamentoService.update(aMedicamento);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public ResponseEntity<Void> print(@RequestParam(value = "nome", defaultValue = "") String aNome) {
		try {
			medicamentoService.print(aNome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}
}
