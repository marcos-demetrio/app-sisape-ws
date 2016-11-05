package com.tcc.sisape.resource;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.tcc.sisape.domain.Agendamento;
import com.tcc.sisape.domain.AgendamentoSintoma;
import com.tcc.sisape.domain.Atendimento;
import com.tcc.sisape.domain.AtendimentoExame;
import com.tcc.sisape.domain.AtendimentoMedicamento;
import com.tcc.sisape.domain.AtendimentoSintoma;
import com.tcc.sisape.service.AgendamentoService;
import com.tcc.sisape.service.AtendimentoService;
import com.tcc.sisape.service.UnidadeBasicaSaudeService;

@CrossOrigin
@RestController
@RequestMapping("/atendimento")
public class AtendimentoResource {

	@Autowired
	private AtendimentoService atendimentoService;

	@Autowired
	private AgendamentoService agendamentoService;

	@Autowired
	public UnidadeBasicaSaudeService unidadeBasicaSaudeService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Atendimento>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Atendimento> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findById(aId));
	}

	@RequestMapping(value = "/cidadao/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Atendimento>> findByCidadao(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findByCidadao(aId));
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

	@RequestMapping(value = "/adoecimento", method = RequestMethod.GET)
	public ResponseEntity<List<Atendimento>> findAdoecimentoAll() {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findAdoecimentoAll());
	}

	@RequestMapping(value = "/adoecimento/relatorio/municipio/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Atendimento>> findAdoecimentoByMunicipioId(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findAdoecimentoByMunicipioId(aId));
	}

	@RequestMapping(value = "/adoecimento/relatorio/ubs/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Atendimento>> findAdoecimentoByUbsId(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findAdoecimentoByUbsId(aId));
	}

	@RequestMapping(value = "/adoecimento/relatorio/periodo", method = RequestMethod.GET)
	public ResponseEntity<List<Atendimento>> findAdoecimentoByDataAtendimentoBetween(
			@RequestParam(value = "aDataInicio") String aDataInicio,
			@RequestParam(value = "aDataFinal") String aDataFinal) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInicio = new Date();
		Date dataFinal = new Date();

		try {
			dataInicio = formatter.parse(aDataInicio);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			dataFinal = formatter.parse(aDataFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(atendimentoService.findAdoecimentoByDataAtendimentoBetween(dataInicio, dataFinal));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody Atendimento aAtendimento) {
		List<AtendimentoExame> listAtendimentoExame = aAtendimento.getAtendimentoExame();
		List<AtendimentoMedicamento> listAtendimentoMedicamento = aAtendimento.getAtendimentoMedicamento();
		List<AtendimentoSintoma> listAtendimentoSintoma = aAtendimento.getAtendimentoSintoma();

		aAtendimento.setAtendimentoExame(null);
		aAtendimento.setAtendimentoMedicamento(null);
		aAtendimento.setAtendimentoSintoma(null);

		Agendamento agendamento = aAtendimento.getAgendamento();
		agendamento.setAtendido(true);

		for (AgendamentoSintoma agendamentoSintoma : agendamento.getAgendamentoSintoma()) {
			agendamentoSintoma.setAgendamento(agendamento);
		}

		agendamentoService.update(agendamento);

		aAtendimento.setAgendamento(agendamento);

		aAtendimento = atendimentoService.create(aAtendimento);

		for (AtendimentoExame atendimentoExame : listAtendimentoExame) {
			atendimentoExame.setAtendimento(aAtendimento);
		}

		for (AtendimentoMedicamento atendimentoMedicamento : listAtendimentoMedicamento) {
			atendimentoMedicamento.setAtendimento(aAtendimento);
		}

		for (AtendimentoSintoma atendimentoSintoma : listAtendimentoSintoma) {
			atendimentoSintoma.setAtendimento(aAtendimento);
		}

		aAtendimento.setAtendimentoExame(listAtendimentoExame);
		aAtendimento.setAtendimentoMedicamento(listAtendimentoMedicamento);
		aAtendimento.setAtendimentoSintoma(listAtendimentoSintoma);

		atendimentoService.update(aAtendimento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aAtendimento.getId())
				.toUri();

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

	@RequestMapping(value = "/relatorio/ubs/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Atendimento>> findByUbsId(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findByUnidadeBasicaSaude(aId));
	}

	@RequestMapping(value = "/relatorio/profissional/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Atendimento>> findByProfissionalId(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findByProfissional(aId));
	}

	@RequestMapping(value = "/relatorio/cidadao/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Atendimento>> findByCidadaoId(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findByCidadao(aId));
	}

	@RequestMapping(value = "/relatorio/periodo", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Atendimento>> findByDataAtendimentoBetween(
			@RequestParam(value = "aDataInicio") String aDataInicio,
			@RequestParam(value = "aDataFinal") String aDataFinal) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInicio = new Date();
		Date dataFinal = new Date();

		try {
			dataInicio = formatter.parse(aDataInicio);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			dataFinal = formatter.parse(aDataFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(atendimentoService.findByDataAtendimentoBetween(dataInicio, dataFinal));
	}
}
