package com.tcc.sisape.resource;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.tcc.sisape.domain.Agendamento;
import com.tcc.sisape.domain.AgendamentoSintoma;
import com.tcc.sisape.domain.Atendimento;
import com.tcc.sisape.domain.AtendimentoExame;
import com.tcc.sisape.domain.AtendimentoMedicamento;
import com.tcc.sisape.domain.AtendimentoSintoma;
import com.tcc.sisape.report.AtendimentoReport;
import com.tcc.sisape.service.AgendamentoService;
import com.tcc.sisape.service.AtendimentoService;
import com.tcc.sisape.service.UnidadeBasicaSaudeService;

import net.sf.jasperreports.engine.JRException;

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
	public Long save(@Valid @RequestBody Atendimento aAtendimento) {
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

		return aAtendimento.getId();
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

	@RequestMapping(value = "print", method = RequestMethod.GET)
	@ResponseBody
	public void print(HttpServletResponse response) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimir(response, atendimentoService.print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printUbs", method = RequestMethod.GET)
	@ResponseBody
	public void printByUbsId(HttpServletResponse response, @RequestParam(value = "aUnidadeBasicaSaude") Long aUnidadeBasicaSaude) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimir(response, atendimentoService.printByUnidadeBasicaSaude(aUnidadeBasicaSaude));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printProfissional", method = RequestMethod.GET)
	@ResponseBody
	public void printByProfissionalId(HttpServletResponse response, @RequestParam(value = "aProfissional") Long aProfissional) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimir(response, atendimentoService.printByProfissional(aProfissional));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printCidadao", method = RequestMethod.GET)
	@ResponseBody
	public void printByCidadaoId(HttpServletResponse response, @RequestParam(value = "aCidadao") Long aCidadao) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimir(response, atendimentoService.printByCidadao(aCidadao));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printPeriodo", method = RequestMethod.GET)
	@ResponseBody
	public void getRpt1(HttpServletResponse response, @RequestParam(value = "aDataInicio") String aDataInicio,
			@RequestParam(value = "aDataFinal") String aDataFinal) throws JRException, IOException {
		
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
		
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimir(response, atendimentoService.printByDataAtendimentoBetween(dataInicio, dataFinal));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printAdoecimento", method = RequestMethod.GET)
	@ResponseBody
	public void printAdoecimento(HttpServletResponse response) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimirAdoecimento(response, atendimentoService.printAdoecimento());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printAdoecimentoMunicipio", method = RequestMethod.GET)
	@ResponseBody
	public void printAdoecimentoByMunicipioId(HttpServletResponse response, @RequestParam(value = "aMunicipio") Long aMunicipio) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimirAdoecimento(response, atendimentoService.printAdoecimentoByMunicipio(aMunicipio));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printAdoecimentoUbs", method = RequestMethod.GET)
	@ResponseBody
	public void printAdoecimentoByUbsId(HttpServletResponse response, @RequestParam(value = "aUnidadeBasicaSaude") Long aUnidadeBasicaSaude) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimirAdoecimento(response, atendimentoService.printAdoecimentoByUbs(aUnidadeBasicaSaude));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printAdoecimentoPeriodo", method = RequestMethod.GET)
	@ResponseBody
	public void printAdoecimentoByDataAtendimentoBetween(HttpServletResponse response,
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

		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimirAdoecimento(response, atendimentoService.printAdoecimentoByDataAtendimentoBetween(dataInicio, dataFinal));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printAtestado", method = RequestMethod.GET)
	@ResponseBody
	public void printAtestado(HttpServletResponse response, @RequestParam(value = "aAtendimento") Long aAtendimento) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimirAtestado(response, atendimentoService.printAtestado(aAtendimento));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printReceita", method = RequestMethod.GET)
	@ResponseBody
	public void printReceita(HttpServletResponse response, @RequestParam(value = "aAtendimento") Long aAtendimento) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimirReceita(response, atendimentoService.printReceita(aAtendimento));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "printExame", method = RequestMethod.GET)
	@ResponseBody
	public void printExame(HttpServletResponse response, @RequestParam(value = "aAtendimento") Long aAtendimento) {
		AtendimentoReport report = new AtendimentoReport();
		try {
			report.imprimirExame(response, atendimentoService.printExame(aAtendimento));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
