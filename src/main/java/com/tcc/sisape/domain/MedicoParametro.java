package com.tcc.sisape.domain;

public class MedicoParametro {
	private boolean horarioMatutino;
	private String horarioMatutinoInicio;//time
	private String horarioMatutinoFim;//time
	
	private boolean horarioVespertino;
	private String horarioVespertinoInicio;//time
	private String horarioVespertinoFim;//time
	
	private boolean horarioNoturno;
	private String horarioNoturnoInicio;//time
	private String horarioNoturnoFim;//time
	
	private Long duracaoPadraoAtendimento;
	
	private ClassificacaoBrasileiraOcupacao cbo;
}
