package com.tcc.sisape.resource;

import java.net.URI;
import java.util.List;
import java.util.Set;

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

import com.tcc.sisape.domain.Agendamento;
import com.tcc.sisape.domain.AgendamentoSintoma;
import com.tcc.sisape.service.AgendamentoService;

@CrossOrigin
@RestController
@RequestMapping("/agendamento")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Agendamento>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Agendamento> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.findById(aId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long aId) {
		agendamentoService.delete(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/sintoma/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarSintoma(@PathVariable("id") Long aId) {
		agendamentoService.deletarSintoma(aId);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Agendamento aAgendamento) {
		Set<AgendamentoSintoma> setAgendamentoSintoma = aAgendamento.getAgendamentoSintoma();

		aAgendamento.setAgendamentoSintoma(null);

		aAgendamento = agendamentoService.create(aAgendamento);

		for (AgendamentoSintoma agendamentoSintoma : setAgendamentoSintoma) {
			agendamentoSintoma.setAgendamento(aAgendamento);
		}

		aAgendamento.setAgendamentoSintoma(setAgendamentoSintoma);

		agendamentoService.update(aAgendamento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aAgendamento.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Agendamento aAgendamento, @PathVariable("id") Long aId) {
		aAgendamento.setId(aId);

		for (AgendamentoSintoma agendamentoSintoma : aAgendamento.getAgendamentoSintoma()) {
			agendamentoSintoma.setAgendamento(aAgendamento);
		}

		agendamentoService.update(aAgendamento);

		return ResponseEntity.noContent().build();
	}
}
