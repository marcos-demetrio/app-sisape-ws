package com.tcc.sisape.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.tcc.sisape.domain.Agendamento;
import com.tcc.sisape.domain.AgendamentoSintoma;
import com.tcc.sisape.domain.Atendimento;
import com.tcc.sisape.domain.AtendimentoExame;
import com.tcc.sisape.domain.AtendimentoMedicamento;
import com.tcc.sisape.domain.AtendimentoSintoma;
import com.tcc.sisape.service.AgendamentoService;
import com.tcc.sisape.service.AtendimentoService;
import com.tcc.sisape.service.UnidadeBasicaSaudeService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public ResponseEntity<Void> print() {
		try {
			atendimentoService.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/printUbs/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> printByUbsId(@PathVariable("id") Long aId) {
		try {
			atendimentoService.printByUnidadeBasicaSaude(aId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/printProfissional/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> printByProfissionalId(@PathVariable("id") Long aId) {
		try {
			atendimentoService.printByProfissional(aId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/printCidadao/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> printByCidadaoId(@PathVariable("id") Long aId) {
		try {
			atendimentoService.printByCidadao(aId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

	/*
	 * @RequestMapping(value = "/printPeriodo", method = RequestMethod.GET)
	 * public ResponseEntity<Void>
	 * printByDataAtendimentoBetween(@RequestParam(value = "aDataInicio") String
	 * aDataInicio,
	 * 
	 * @RequestParam(value = "aDataFinal") String aDataFinal) {
	 * 
	 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); Date
	 * dataInicio = new Date(); Date dataFinal = new Date();
	 * 
	 * try { dataInicio = formatter.parse(aDataInicio); } catch (ParseException
	 * e) { e.printStackTrace(); }
	 * 
	 * try { dataFinal = formatter.parse(aDataFinal); } catch (ParseException e)
	 * { e.printStackTrace(); }
	 * 
	 * try { atendimentoService.printByDataAtendimentoBetween(dataInicio,
	 * dataFinal); } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return ResponseEntity.noContent().build(); }
	 */

	@RequestMapping(value = "printPeriodo", method = RequestMethod.GET)
	@ResponseBody
	public void getRpt1(HttpServletResponse response, @RequestParam(value = "aDataInicio") String aDataInicio,
			@RequestParam(value = "aDataFinal") String aDataFinal) throws JRException, IOException {
		Map<String, Object> params = new HashMap<>();

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

		List<Atendimento> listaAtendimento = atendimentoService.printByDataAtendimentoBetween(dataInicio, dataFinal);

		JasperReport jasperReport = JasperCompileManager.compileReport(
				this.getClass().getClassLoader().getResource("").getPath() + "/jasper/reportAtendimento.jrxml");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
				new JRBeanCollectionDataSource(listaAtendimento));

		// response.setContentType("application/pdf");
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=Atendimento.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}

	@RequestMapping(value = "/printAdoecimento", method = RequestMethod.GET)
	public ResponseEntity<Void> printAdoecimento() {
		try {
			atendimentoService.printAdoecimento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/printAdoecimentoMunicipio/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> printAdoecimentoByMunicipioId(@PathVariable("id") Long aId) {
		try {
			atendimentoService.printAdoecimentoByMunicipio(aId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/printAdoecimentoUbs/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> printAdoecimentoByUbsId(@PathVariable("id") Long aId) {
		try {
			atendimentoService.printAdoecimentoByUbs(aId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/printAdoecimentoPeriodo", method = RequestMethod.GET)
	public ResponseEntity<Void> printAdoecimentoByDataAtendimentoBetween(@RequestParam(value = "aDataInicio") String aDataInicio,

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

		try {
			atendimentoService.printAdoecimentoByDataAtendimentoBetween(dataInicio, dataFinal);
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

}
