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

import com.tcc.sisape.domain.AgendamentoSintoma;
import com.tcc.sisape.domain.Atendimento;
import com.tcc.sisape.domain.AtendimentoExame;
import com.tcc.sisape.domain.AtendimentoMedicamento;
import com.tcc.sisape.domain.AtendimentoSintoma;
import com.tcc.sisape.service.AtendimentoService;

@CrossOrigin
@RestController
@RequestMapping("/atendimento")
public class AtendimentoResource {

	@Autowired
	private AtendimentoService atendimentoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Atendimento>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Atendimento> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findById(aId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long aId) {
		atendimentoService.delete(aId);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/exame/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarExame(@PathVariable("id") Long aId) {
		atendimentoService.deletarExame(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/medicamento/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarMedicamento(@PathVariable("id") Long aId) {
		atendimentoService.deletarMedicamento(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/sintoma/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarSintoma(@PathVariable("id") Long aId) {
		atendimentoService.deletarSintoma(aId);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Atendimento aAtendimento) {
		Set<AtendimentoExame> setAtendimentoExame = aAtendimento.getAtendimentoExame();
		Set<AtendimentoMedicamento> setAtendimentoMedicamento = aAtendimento.getAtendimentoMedicamento();
		Set<AtendimentoSintoma> setAtendimentoSintoma = aAtendimento.getAtendimentoSintoma();
		
		aAtendimento.setAtendimentoExame(null);
		aAtendimento.setAtendimentoMedicamento(null);
		aAtendimento.setAtendimentoSintoma(null);
		
		aAtendimento = atendimentoService.create(aAtendimento);
		
		for (AtendimentoExame atendimentoExame : setAtendimentoExame) {
			atendimentoExame.setAtendimento(aAtendimento);
		}

		for (AtendimentoMedicamento atendimentoMedicamento : setAtendimentoMedicamento) {
			atendimentoMedicamento.setAtendimento(aAtendimento);
		}

		for (AtendimentoSintoma atendimentoSintoma : setAtendimentoSintoma) {
			atendimentoSintoma.setAtendimento(aAtendimento);
		}
		
		aAtendimento.setAtendimentoExame(setAtendimentoExame);
		aAtendimento.setAtendimentoMedicamento(setAtendimentoMedicamento);
		aAtendimento.setAtendimentoSintoma(setAtendimentoSintoma);
		
		atendimentoService.update(aAtendimento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aAtendimento.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Atendimento aAtendimento, @PathVariable("id") Long aId) {
		aAtendimento.setId(aId);
		
		for (AtendimentoExame atendimentoExame : aAtendimento.getAtendimentoExame()) {
			atendimentoExame.setAtendimento(aAtendimento);
		}

		for (AtendimentoMedicamento atendimentoMedicamento : aAtendimento.getAtendimentoMedicamento()) {
			atendimentoMedicamento.setAtendimento(aAtendimento);
		}

		for (AtendimentoSintoma atendimentoSintoma : aAtendimento.getAtendimentoSintoma()) {
			atendimentoSintoma.setAtendimento(aAtendimento);
		}

		atendimentoService.update(aAtendimento);

		return ResponseEntity.noContent().build();
	}
}
