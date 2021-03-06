package com.tcc.sisape.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.sisape.domain.UnidadeBasicaSaude;
import com.tcc.sisape.domain.UnidadeBasicaSaudeParametro;
import com.tcc.sisape.domain.UnidadeBasicaSaudeZonaAtendimento;
import com.tcc.sisape.report.UnidadeBasicaSaudeReport;
import com.tcc.sisape.service.UnidadeBasicaSaudeService;

@CrossOrigin
@RestController
@RequestMapping("/ubs")
public class UnidadeBasicaSaudeResource {

	@Autowired
	private UnidadeBasicaSaudeService unidadeBasicaSaudeService;

	@RequestMapping(method = RequestMethod.GET) // produces =
												// {MediaType.APPLICATION_JSON_VALUE,
												// MediaType.APPLICATION_XML_VALUE}
	public ResponseEntity<List<UnidadeBasicaSaude>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(unidadeBasicaSaudeService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UnidadeBasicaSaude> buscarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(unidadeBasicaSaudeService.findById(id));
	}

	@RequestMapping(value = "/nome", method = RequestMethod.GET)
	public ResponseEntity<List<UnidadeBasicaSaude>> pesquisar(
			@RequestParam(value = "nome", defaultValue = "") String aNome) {
		return ResponseEntity.status(HttpStatus.OK).body(unidadeBasicaSaudeService.findByNome(aNome));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		unidadeBasicaSaudeService.deletar(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/zona/{idZona}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarZonaAtendimento(@PathVariable("idZona") Long aIdZona) {
		unidadeBasicaSaudeService.deletarZonaAtendimento(aIdZona);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody UnidadeBasicaSaude unidadeBasicaSaude) {

		UnidadeBasicaSaudeParametro ubsParametro = unidadeBasicaSaude.getParametroUbs();
		List<UnidadeBasicaSaudeZonaAtendimento> listZonaAtendimento = unidadeBasicaSaude.getZonaAtendimento();

		unidadeBasicaSaude.setParametroUbs(null);
		unidadeBasicaSaude.setZonaAtendimento(null);

		unidadeBasicaSaude = unidadeBasicaSaudeService.criar(unidadeBasicaSaude);

		ubsParametro.setUnidadeBasicaSaude(unidadeBasicaSaude);

		for (UnidadeBasicaSaudeZonaAtendimento zonaAtendimento : listZonaAtendimento) {
			zonaAtendimento.setUnidadeBasicaSaude(unidadeBasicaSaude);
		}

		unidadeBasicaSaude.setParametroUbs(ubsParametro);
		unidadeBasicaSaude.setZonaAtendimento(listZonaAtendimento);

		unidadeBasicaSaudeService.alterar(unidadeBasicaSaude);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(unidadeBasicaSaude.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody UnidadeBasicaSaude unidadeBasicaSaude, @PathVariable Long id) {
		unidadeBasicaSaude.setId(id);
		unidadeBasicaSaude.getParametroUbs().setUnidadeBasicaSaude(unidadeBasicaSaude);

		for (UnidadeBasicaSaudeZonaAtendimento zonaAtendimento : unidadeBasicaSaude.getZonaAtendimento()) {
			zonaAtendimento.setUnidadeBasicaSaude(unidadeBasicaSaude);
		}

		unidadeBasicaSaudeService.alterar(unidadeBasicaSaude);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "print", method = RequestMethod.GET)
	@ResponseBody
	public void print(HttpServletResponse response, @RequestParam(value = "nome", defaultValue = "") String aNome) {
		UnidadeBasicaSaudeReport report = new UnidadeBasicaSaudeReport();
		try {
			report.imprimir(response, unidadeBasicaSaudeService.print(aNome));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
