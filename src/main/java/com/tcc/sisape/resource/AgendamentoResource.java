package com.tcc.sisape.resource;

import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

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
import com.tcc.sisape.service.AgendamentoSenha;
import com.tcc.sisape.service.AgendamentoService;

@CrossOrigin
@RestController
@RequestMapping("/agendamento")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Agendamento>> findAll() {
		List<Agendamento> listAgendamento = agendamentoService.findAll();

		Calendar calendarData = Calendar.getInstance();
		Calendar calendarHora = Calendar.getInstance();

		for (Agendamento a : listAgendamento) {
			calendarData.setTime(a.getDataAgendamento());
			calendarHora.setTime(a.getHoraAgendamento());

			calendarData.set(Calendar.HOUR, calendarHora.get(Calendar.HOUR_OF_DAY));
			calendarData.set(Calendar.MINUTE, calendarHora.get(Calendar.MINUTE));
			calendarData.set(Calendar.SECOND, 0);

			a.setDataAgendamento(calendarData.getTime());
		}

		return ResponseEntity.status(HttpStatus.OK).body(listAgendamento);
	}

	@RequestMapping(value = "/naoatendido", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Agendamento>> findNaoAtendido() {
		List<Agendamento> listAgendamento = agendamentoService.findAgendamentoNaoAtendido();

		Calendar calendarData = Calendar.getInstance();
		Calendar calendarHora = Calendar.getInstance();

		for (Agendamento a : listAgendamento) {
			calendarData.setTime(a.getDataAgendamento());
			calendarHora.setTime(a.getHoraAgendamento());

			calendarData.set(Calendar.HOUR, calendarHora.get(Calendar.HOUR_OF_DAY));
			calendarData.set(Calendar.MINUTE, calendarHora.get(Calendar.MINUTE));
			calendarData.set(Calendar.SECOND, 0);

			a.setDataAgendamento(calendarData.getTime());
		}

		return ResponseEntity.status(HttpStatus.OK).body(listAgendamento);
	}

	@RequestMapping(value = "/horarios/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Set<AgendamentoSenha>> gerarHorarios(@PathVariable("id") Long aIdUbs) {
		return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.gerarHorarios(aIdUbs));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Agendamento> findById(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.findById(aId));
	}

	@RequestMapping(value = "/cidadao/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Agendamento>> findByCidadao(@PathVariable("id") Long aId) {
		return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.findByCidadao(aId));
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
	public ResponseEntity<Void> save(@RequestBody Agendamento aAgendamento) {
		List<AgendamentoSintoma> listAgendamentoSintoma = aAgendamento.getAgendamentoSintoma();

		aAgendamento.setAgendamentoSintoma(null);

		aAgendamento = agendamentoService.create(aAgendamento);

		for (AgendamentoSintoma agendamentoSintoma : listAgendamentoSintoma) {
			agendamentoSintoma.setAgendamento(aAgendamento);
		}

		aAgendamento.setAgendamentoSintoma(listAgendamentoSintoma);

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
