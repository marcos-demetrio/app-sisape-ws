package com.tcc.sisape.resource;

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

import com.tcc.sisape.domain.ProfissionalAgenda;
import com.tcc.sisape.domain.ProfissionalLotacao;
import com.tcc.sisape.service.ProfissionalAgendaService;
import com.tcc.sisape.service.ProfissionalLotacaoService;

@CrossOrigin
@RestController
@RequestMapping("/agendaprofissional")
public class ProfissionalAgendaResource {

	@Autowired
	private ProfissionalAgendaService profissionalAgendaService;

	@Autowired
	private ProfissionalLotacaoService profissionalLotacaoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProfissionalAgenda>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(profissionalAgendaService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Set<ProfissionalAgenda>> buscarPorLotacao(@PathVariable("id") Long aId) {

		ProfissionalLotacao lotacao = profissionalLotacaoService.findById(aId);
		Set<ProfissionalAgenda> profissionalAgenda = profissionalAgendaService.findByLotacao(lotacao);

		return ResponseEntity.status(HttpStatus.OK).body(profissionalAgenda);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		profissionalAgendaService.deletar(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.POST })
	public ResponseEntity<Void> salvar(@Valid @RequestBody List<ProfissionalAgenda> profissionalAgendaList,
			@PathVariable("id") Long aIdLotacao) {

		ProfissionalLotacao lotacao = profissionalLotacaoService.findById(aIdLotacao);

		for (ProfissionalAgenda profissionalAgenda : profissionalAgendaList) {
			profissionalAgenda.setId(null);
			profissionalAgenda.setLotacao(lotacao);

			profissionalAgendaService.criar(profissionalAgenda);
		}

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public ResponseEntity<Void> alterar(@Valid @RequestBody List<ProfissionalAgenda> profissionalAgendaList,
			@PathVariable("id") Long aIdLotacao) {

		ProfissionalLotacao lotacao = profissionalLotacaoService.findById(aIdLotacao);

		for (ProfissionalAgenda profissionalAgenda : profissionalAgendaList) {
			profissionalAgenda.setLotacao(lotacao);

			profissionalAgendaService.alterar(profissionalAgenda);
		}

		return ResponseEntity.noContent().build();
	}
}
