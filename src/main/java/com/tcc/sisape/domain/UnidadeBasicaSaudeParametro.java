package com.tcc.sisape.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class UnidadeBasicaSaudeParametro implements Serializable {

	private static final long serialVersionUID = -6552751571731222036L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_unidade_basica_saude_parametro")
	@Column(name = "i_unidade_basica_saude_parametro")
	private Long id;

	@OneToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude unidadeBasicaSaude;

	@Column(nullable = false)
	private boolean complexidadeAtencaoBasica;

	@Column(nullable = false)
	private boolean complexidadeMedia;

	@Column(nullable = false)
	private boolean complexidadeAlta;

	@Column(nullable = false)
	private boolean tipoServicoAdm;

	@Column(nullable = false)
	private boolean tipoServicoCurativo;

	@Column(nullable = false)
	private boolean tipoServicoDemanda;

	@Column(nullable = false)
	private boolean tipoServicoEscuta;

	@Column(nullable = false)
	private boolean tipoServicoExame;

	@Column(nullable = false)
	private boolean tipoServicoNebulizacao;

	@Column(nullable = false)
	private boolean tipoServicoOdontologia;

	@Column(nullable = false)
	private boolean tipoServicoProcedimento;

	@Column(nullable = false)
	private boolean tipoServicoVacina;

	@Column(nullable = false)
	private boolean horarioMatutino;

	private int horarioMatutinoInicio;

	private int horarioMatutinoFim;

	@Column(nullable = false)
	private boolean horarioVespertino;

	private int horarioVespertinoInicio;

	private int horarioVespertinoFim;

	@Column(nullable = false)
	private boolean horarioNoturno;

	private int horarioNoturnoInicio;

	private int horarioNoturnoFim;

	@Column(nullable = false)
	private Long duracaoPadraoAtendimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUnidadeBasicaSaude(UnidadeBasicaSaude unidadeBasicaSaude) {
		this.unidadeBasicaSaude = unidadeBasicaSaude;
	}

	public boolean isComplexidadeAtencaoBasica() {
		return this.complexidadeAtencaoBasica;
	}

	public void setComplexidadeAtencaoBasica(boolean complexidadeAtencaoBasica) {
		this.complexidadeAtencaoBasica = complexidadeAtencaoBasica;
	}

	public boolean isComplexidadeMedia() {
		return this.complexidadeMedia;
	}

	public void setComplexidadeMedia(boolean complexidadeMedia) {
		this.complexidadeMedia = complexidadeMedia;
	}

	public boolean isComplexidadeAlta() {
		return this.complexidadeAlta;
	}

	public void setComplexidadeAlta(boolean complexidadeAlta) {
		this.complexidadeAlta = complexidadeAlta;
	}

	public boolean isTipoServicoAdm() {
		return this.tipoServicoAdm;
	}

	public void setTipoServicoAdm(boolean tipoServicoAdm) {
		this.tipoServicoAdm = tipoServicoAdm;
	}

	public boolean isTipoServicoCurativo() {
		return this.tipoServicoCurativo;
	}

	public void setTipoServicoCurativo(boolean tipoServicoCurativo) {
		this.tipoServicoCurativo = tipoServicoCurativo;
	}

	public boolean isTipoServicoDemanda() {
		return this.tipoServicoDemanda;
	}

	public void setTipoServicoDemanda(boolean tipoServicoDemanda) {
		this.tipoServicoDemanda = tipoServicoDemanda;
	}

	public boolean isTipoServicoEscuta() {
		return this.tipoServicoEscuta;
	}

	public void setTipoServicoEscuta(boolean tipoServicoEscuta) {
		this.tipoServicoEscuta = tipoServicoEscuta;
	}

	public boolean isTipoServicoExame() {
		return this.tipoServicoExame;
	}

	public void setTipoServicoExame(boolean tipoServicoExame) {
		this.tipoServicoExame = tipoServicoExame;
	}

	public boolean isTipoServicoNebulizacao() {
		return this.tipoServicoNebulizacao;
	}

	public void setTipoServicoNebulizacao(boolean tipoServicoNebulizacao) {
		this.tipoServicoNebulizacao = tipoServicoNebulizacao;
	}

	public boolean isTipoServicoOdontologia() {
		return this.tipoServicoOdontologia;
	}

	public void setTipoServicoOdontologia(boolean tipoServicoOdontologia) {
		this.tipoServicoOdontologia = tipoServicoOdontologia;
	}

	public boolean isTipoServicoProcedimento() {
		return this.tipoServicoProcedimento;
	}

	public void setTipoServicoProcedimento(boolean tipoServicoProcedimento) {
		this.tipoServicoProcedimento = tipoServicoProcedimento;
	}

	public boolean isTipoServicoVacina() {
		return this.tipoServicoVacina;
	}

	public void setTipoServicoVacina(boolean tipoServicoVacina) {
		this.tipoServicoVacina = tipoServicoVacina;
	}

	public boolean isHorarioMatutino() {
		return this.horarioMatutino;
	}

	public void setHorarioMatutino(boolean horarioMatutino) {
		this.horarioMatutino = horarioMatutino;
	}

	public int getHorarioMatutinoInicio() {
		return this.horarioMatutinoInicio;
	}

	public void setHorarioMatutinoInicio(int horarioMatutinoInicio) {
		this.horarioMatutinoInicio = horarioMatutinoInicio;
	}

	public int getHorarioMatutinoFim() {
		return this.horarioMatutinoFim;
	}

	public void setHorarioMatutinoFim(int horarioMatutinoFim) {
		this.horarioMatutinoFim = horarioMatutinoFim;
	}

	public boolean isHorarioVespertino() {
		return this.horarioVespertino;
	}

	public void setHorarioVespertino(boolean horarioVespertino) {
		this.horarioVespertino = horarioVespertino;
	}

	public int getHorarioVespertinoInicio() {
		return this.horarioVespertinoInicio;
	}

	public void setHorarioVespertinoInicio(int horarioVespertinoInicio) {
		this.horarioVespertinoInicio = horarioVespertinoInicio;
	}

	public int getHorarioVespertinoFim() {
		return this.horarioVespertinoFim;
	}

	public void setHorarioVespertinoFim(int horarioVespertinoFim) {
		this.horarioVespertinoFim = horarioVespertinoFim;
	}

	public boolean isHorarioNoturno() {
		return this.horarioNoturno;
	}

	public void setHorarioNoturno(boolean horarioNoturno) {
		this.horarioNoturno = horarioNoturno;
	}

	public int getHorarioNoturnoInicio() {
		return this.horarioNoturnoInicio;
	}

	public void setHorarioNoturnoInicio(int horarioNoturnoInicio) {
		this.horarioNoturnoInicio = horarioNoturnoInicio;
	}

	public int getHorarioNoturnoFim() {
		return this.horarioNoturnoFim;
	}

	public void setHorarioNoturnoFim(int horarioNoturnoFim) {
		this.horarioNoturnoFim = horarioNoturnoFim;
	}

	public Long getDuracaoPadraoAtendimento() {
		return this.duracaoPadraoAtendimento;
	}

	public void setDuracaoPadraoAtendimento(Long duracaoPadraoAtendimento) {
		this.duracaoPadraoAtendimento = duracaoPadraoAtendimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((unidadeBasicaSaude == null) ? 0 : unidadeBasicaSaude.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeBasicaSaudeParametro other = (UnidadeBasicaSaudeParametro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (unidadeBasicaSaude == null) {
			if (other.unidadeBasicaSaude != null)
				return false;
		} else if (!unidadeBasicaSaude.equals(other.unidadeBasicaSaude))
			return false;
		return true;
	}
}
