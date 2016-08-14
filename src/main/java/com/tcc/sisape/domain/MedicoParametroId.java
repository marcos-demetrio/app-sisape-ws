package com.tcc.sisape.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MedicoParametroId implements Serializable{

	private static final long serialVersionUID = -6835174482820268734L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_medico", referencedColumnName = "i_medico", nullable = false)
	private Medico medico;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", referencedColumnName = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude ubs;
}
