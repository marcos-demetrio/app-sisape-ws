package com.tcc.sisape.domain;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class UnidadeBasicaSaudeParametro {
	private boolean complexidadeAtencaoBasica;
	private boolean complexidadeMedia;
	private boolean complexidadeAlta;
	
	private boolean tipoServicoAdm;
	private boolean tipoServicoCurativo;
	private boolean tipoServicoDemanda;
	private boolean tipoServicoEscuta;
	private boolean tipoServicoExame;
	private boolean tipoServicoNebulizacao;
	private boolean tipoServicoOdontologia;
	private boolean tipoServicoProcedimento;
	private boolean tipoServicoVacina;
	
	private boolean horarioMatutino;
	
	@Temporal(TemporalType.TIME)
	private Time horarioMatutinoInicio;
	
	@Temporal(TemporalType.TIME)
	private Time horarioMatutinoFim;
	
	private boolean horarioVespertino;
	
	@Temporal(TemporalType.TIME)
	private Time horarioVespertinoInicio;
	
	@Temporal(TemporalType.TIME)
	private Time horarioVespertinoFim;
	
	private boolean horarioNoturno;
	
	@Temporal(TemporalType.TIME)
	private Time horarioNoturnoInicio;
	
	@Temporal(TemporalType.TIME)
	private Time horarioNoturnoFim;
	
	private Long duracaoPadraoAtendimento;
	
	
}
