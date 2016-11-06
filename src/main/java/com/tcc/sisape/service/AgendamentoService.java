package com.tcc.sisape.service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Agendamento;
import com.tcc.sisape.domain.Cidadao;
import com.tcc.sisape.domain.UnidadeBasicaSaude;
import com.tcc.sisape.domain.enumdados.PeriodoDia;
import com.tcc.sisape.repository.AgendamentoRepository;
import com.tcc.sisape.repository.AgendamentoSintomaRepository;
import com.tcc.sisape.service.exceptions.AgendamentoNaoEncontradoException;
import com.tcc.sisape.service.exceptions.AgendamentoSintomaNaoEncontradoException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Autowired
	private CidadaoService cidadaoService;

	@Autowired
	private AgendamentoSintomaRepository agendamentoSintomaRepository;

	@Autowired
	private UnidadeBasicaSaudeService unidadeBasicaSaudeService;

	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
	}

	public List<Agendamento> findByCidadao(Long aId) {
		Cidadao cidadao = cidadaoService.findById(aId);
		
		return agendamentoRepository.findByCidadao(cidadao);
	}

	public List<Agendamento> findAgendamentoNaoAtendido() {
		return agendamentoRepository.findByAtendido(false);
	}

	private Set<AgendamentoSenha> gerarHorarioPeriodo(UnidadeBasicaSaude aUnidadeBasicaSaude, PeriodoDia aPeriodoDia,
			int aNumeroSenha) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT-0200"));

		int tempoPadraoAtendimento = aUnidadeBasicaSaude.getParametroUbs().getDuracaoPadraoAtendimento().intValue();

		int numeroSenha = aNumeroSenha;
		int horaInicio = 0;
		int horaFim = 0;

		switch (aPeriodoDia) {
		case MATUTINO:
			horaInicio = aUnidadeBasicaSaude.getParametroUbs().getHorarioMatutinoInicio();
			horaFim = aUnidadeBasicaSaude.getParametroUbs().getHorarioMatutinoFim();

			break;

		case VESPERTINO:
			horaInicio = aUnidadeBasicaSaude.getParametroUbs().getHorarioVespertinoInicio();
			horaFim = aUnidadeBasicaSaude.getParametroUbs().getHorarioVespertinoFim();

			break;

		case NOTURNO:
			horaInicio = aUnidadeBasicaSaude.getParametroUbs().getHorarioNoturnoInicio();
			horaFim = aUnidadeBasicaSaude.getParametroUbs().getHorarioNoturnoFim();

			break;
		}

		Set<AgendamentoSenha> agendamentoSenha = new HashSet<AgendamentoSenha>();

		for (int horaIndex = horaInicio; horaIndex < horaFim; horaIndex++) {

			for (int minutoIndex = 0; minutoIndex <= (60
					- tempoPadraoAtendimento); minutoIndex += tempoPadraoAtendimento) {

				calendar.set(Calendar.HOUR_OF_DAY, horaIndex);
				calendar.set(Calendar.MINUTE, minutoIndex);
				calendar.setTimeZone(TimeZone.getTimeZone("GMT-0200"));

				numeroSenha++;

				agendamentoSenha.add(new AgendamentoSenha(calendar.getTime(), numeroSenha, true));
			}
		}

		return agendamentoSenha;
	}

	public Set<AgendamentoSenha> gerarHorarios(Long aCodigoUbs) {
		UnidadeBasicaSaude unidadeBasicaSaude = unidadeBasicaSaudeService.findById(aCodigoUbs);

		Set<AgendamentoSenha> agendamentoSenhaSet = new HashSet<AgendamentoSenha>();

		int numeroSenha = 0;

		if (unidadeBasicaSaude.getParametroUbs().isHorarioMatutino()) {
			Set<AgendamentoSenha> agendamentoSenhaMatutino = this.gerarHorarioPeriodo(unidadeBasicaSaude,
					PeriodoDia.MATUTINO, numeroSenha);

			for (AgendamentoSenha agendamentoSenha : agendamentoSenhaMatutino) {
				agendamentoSenhaSet.add(agendamentoSenha);
			}
		}

		numeroSenha = agendamentoSenhaSet.size();

		if (unidadeBasicaSaude.getParametroUbs().isHorarioVespertino()) {
			Set<AgendamentoSenha> agendamentoSenhaVespertino = this.gerarHorarioPeriodo(unidadeBasicaSaude,
					PeriodoDia.VESPERTINO, numeroSenha);

			for (AgendamentoSenha agendamentoSenha : agendamentoSenhaVespertino) {
				agendamentoSenhaSet.add(agendamentoSenha);
			}
		}

		numeroSenha = agendamentoSenhaSet.size();

		if (unidadeBasicaSaude.getParametroUbs().isHorarioNoturno()) {
			Set<AgendamentoSenha> agendamentoSenhaNoturno = this.gerarHorarioPeriodo(unidadeBasicaSaude,
					PeriodoDia.NOTURNO, numeroSenha);

			for (AgendamentoSenha agendamentoSenha : agendamentoSenhaNoturno) {
				agendamentoSenhaSet.add(agendamentoSenha);
			}
		}

		return agendamentoSenhaSet;
	}

	public Agendamento findById(Long aId) {
		Agendamento agendamento = agendamentoRepository.findOne(aId);

		if (agendamento == null) {
			throw new AgendamentoNaoEncontradoException("Agendamento não encontrado.");
		}

		return agendamento;
	}

	public void delete(Long aId) {
		try {
			agendamentoRepository.delete(aId);
		} catch (EmptyResultDataAccessException e) {
			throw new AgendamentoNaoEncontradoException("Agendamento não encontrado.");
		}
	}

	public void deletarSintoma(Long id) {
		try {
			agendamentoSintomaRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AgendamentoSintomaNaoEncontradoException("Agendamento Sintoma não encontrado.");
		}
	}

	public Agendamento create(Agendamento aAgendamento) {
		aAgendamento.setId(null);

		return agendamentoRepository.save(aAgendamento);
	}

	public void update(Agendamento aAgendamento) {
		findById(aAgendamento.getId());

		agendamentoRepository.save(aAgendamento);
	}
}
