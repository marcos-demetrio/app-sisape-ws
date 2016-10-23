package com.tcc.sisape.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Agendamento;
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
	private AgendamentoSintomaRepository agendamentoSintomaRepository;

	@Autowired
	private UnidadeBasicaSaudeService unidadeBasicaSaudeService;

	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
	}

	private AgendamentoPeriodoDia gerarHorarioPeriodo(UnidadeBasicaSaude aUnidadeBasicaSaude, PeriodoDia aPeriodoDia) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT-0200"));

		int tempoPadraoAtendimento = aUnidadeBasicaSaude.getParametroUbs().getDuracaoPadraoAtendimento().intValue();

		Date horarioInicio = null;
		Date horarioFim = null;

		switch (aPeriodoDia) {
		case MATUTINO:
			horarioInicio = aUnidadeBasicaSaude.getParametroUbs().getHorarioMatutinoInicio();
			horarioFim = aUnidadeBasicaSaude.getParametroUbs().getHorarioMatutinoFim();

			break;

		case VESPERTINO:
			horarioInicio = aUnidadeBasicaSaude.getParametroUbs().getHorarioVespertinoInicio();
			horarioFim = aUnidadeBasicaSaude.getParametroUbs().getHorarioVespertinoFim();

			break;

		case NOTURNO:
			horarioInicio = aUnidadeBasicaSaude.getParametroUbs().getHorarioNoturnoInicio();
			horarioFim = aUnidadeBasicaSaude.getParametroUbs().getHorarioNoturnoFim();

			break;
		}

		calendar.setTime(horarioInicio);
		int horaInicio = calendar.get(Calendar.HOUR_OF_DAY);

		calendar.setTime(horarioFim);
		int horaFim = calendar.get(Calendar.HOUR_OF_DAY);

		int numeroSenha = 0;

		Set<AgendamentoSenha> agendamentoSenha = new HashSet<AgendamentoSenha>();

		for (int horaIndex = horaInicio; horaIndex < horaFim; horaIndex++) {

			for (int minutoIndex = 0; minutoIndex <= (60
					- tempoPadraoAtendimento); minutoIndex += tempoPadraoAtendimento) {

				numeroSenha++;
				calendar.set(Calendar.HOUR_OF_DAY, horaIndex);
				calendar.set(Calendar.MINUTE, minutoIndex);
				calendar.setTimeZone(TimeZone.getTimeZone("GMT-0200"));

				agendamentoSenha.add(new AgendamentoSenha(calendar.getTime(), numeroSenha, true));
			}
		}

		AgendamentoPeriodoDia horarioPeriodoDia = new AgendamentoPeriodoDia();

		horarioPeriodoDia.setPeriodoDia(aPeriodoDia);
		horarioPeriodoDia.setSenhas(agendamentoSenha);

		return horarioPeriodoDia;
	}

	public Set<AgendamentoPeriodoDia> gerarHorarios(Long aCodigoUbs) {
		UnidadeBasicaSaude unidadeBasicaSaude = unidadeBasicaSaudeService.findById(aCodigoUbs);

		Set<AgendamentoPeriodoDia> horarioPeriodoDiaSet = new HashSet<AgendamentoPeriodoDia>();

		if (unidadeBasicaSaude.getParametroUbs().isHorarioMatutino()) {
			horarioPeriodoDiaSet.add(this.gerarHorarioPeriodo(unidadeBasicaSaude, PeriodoDia.MATUTINO));
		}

		if (unidadeBasicaSaude.getParametroUbs().isHorarioVespertino()) {
			horarioPeriodoDiaSet.add(this.gerarHorarioPeriodo(unidadeBasicaSaude, PeriodoDia.VESPERTINO));
		}

		if (unidadeBasicaSaude.getParametroUbs().isHorarioNoturno()) {
			horarioPeriodoDiaSet.add(this.gerarHorarioPeriodo(unidadeBasicaSaude, PeriodoDia.NOTURNO));
		}

		return horarioPeriodoDiaSet;
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
