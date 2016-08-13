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

import com.tcc.sisape.domain.Paciente;
import com.tcc.sisape.service.PacientesService;

@CrossOrigin
@RestController
@RequestMapping("/pacientes")
public class PacientesResource {
	
	@Autowired
	private PacientesService pacientesService;

	@RequestMapping(method = RequestMethod.GET)//produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	public ResponseEntity<List<Paciente>> buscarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(pacientesService.findAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Paciente> buscarPorId(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(pacientesService.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
		pacientesService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Paciente paciente){
		paciente = pacientesService.criar(paciente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(paciente.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Paciente paciente, @PathVariable Long id){
		paciente.setId(id);
		
		pacientesService.alterar(paciente);
		
		return ResponseEntity.noContent().build();
	}
}
