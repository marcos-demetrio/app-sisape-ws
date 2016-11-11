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

import com.tcc.sisape.domain.Profissional;
import com.tcc.sisape.service.ProfissionalService;

@CrossOrigin
@RestController
@RequestMapping("/profissional")
public class ProfissionalResource {

	@Autowired
	private ProfissionalService profissionalService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Profissional>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(profissionalService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Profissional> buscarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(profissionalService.findById(id));
	}

	@RequestMapping(value = "/nome", method = RequestMethod.GET)
	public ResponseEntity<List<Profissional>> pesquisar(@RequestParam(value = "nome", defaultValue = "") String aNome) {
		return ResponseEntity.status(HttpStatus.OK).body(profissionalService.findByNome(aNome));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		profissionalService.deletar(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Profissional profissional) {
		profissional = profissionalService.criar(profissional);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profissional.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Profissional profissional, @PathVariable Long id) {
		profissional.setId(id);

		profissionalService.alterar(profissional);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public ResponseEntity<Void> print(@RequestParam(value = "nome", defaultValue = "") String aNome) {
		try {
			profissionalService.print(aNome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}
}
