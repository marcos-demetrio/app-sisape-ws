package com.tcc.sisape.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Atendimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_atendimento")
	@Column(name = "i_atendimento")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "i_agendamento", referencedColumnName = "i_agendamento")
	private Agendamento agendamento;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataAtendimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date horaAtendimento;

	@Column(nullable = true)
	private int pressaoMaxima;

	@Column(nullable = true)
	private int pressaoMinima;

	@Column(precision = 5, scale = 2, nullable = true)
	private Double temperatura;

	@Column(precision = 5, scale = 2, nullable = true)
	private Double peso;

	@Column(precision = 5, scale = 2, nullable = true)
	private Double altura;

	@Column(precision = 5, scale = 2, nullable = true)
	private Double imc;

	@Column(precision = 5, scale = 2, nullable = true)
	private Double frequenciaCardiaca;

	@Column(precision = 5, scale = 2, nullable = true)
	private Double frequenciaRespiratoria;

	@Column(length = 5120, nullable = false)
	private String subjetivo;

	@Column(length = 5120, nullable = false)
	private String objetivo;

	@Column(length = 5120, nullable = false)
	private String avaliacao;

	@Column(length = 5120, nullable = false)
	private String plano;

	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
	private List<AtendimentoExame> atendimentoExame;

	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
	private List<AtendimentoMedicamento> atendimentoMedicamento;

	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
	private List<AtendimentoSintoma> atendimentoSintoma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Date getHoraAtendimento() {
		return horaAtendimento;
	}

	public void setHoraAtendimento(Date horaAtendimento) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(horaAtendimento);
		calendar.set(Calendar.SECOND, 0);

		this.horaAtendimento = calendar.getTime();
	}

	public int getPressaoMaxima() {
		return pressaoMaxima;
	}

	public void setPressaoMaxima(int pressaoMaxima) {
		this.pressaoMaxima = pressaoMaxima;
	}

	public int getPressaoMinima() {
		return pressaoMinima;
	}

	public void setPressaoMinima(int pressaoMinima) {
		this.pressaoMinima = pressaoMinima;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public Double getFrequenciaCardiaca() {
		return frequenciaCardiaca;
	}

	public void setFrequenciaCardiaca(Double frequenciaCardiaca) {
		this.frequenciaCardiaca = frequenciaCardiaca;
	}

	public Double getFrequenciaRespiratoria() {
		return frequenciaRespiratoria;
	}

	public void setFrequenciaRespiratoria(Double frequenciaRespiratoria) {
		this.frequenciaRespiratoria = frequenciaRespiratoria;
	}

	public String getSubjetivo() {
		return subjetivo;
	}

	public void setSubjetivo(String subjetivo) {
		this.subjetivo = subjetivo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public List<AtendimentoExame> getAtendimentoExame() {
		return this.atendimentoExame;
	}

	public void setAtendimentoExame(List<AtendimentoExame> atendimentoExame) {
		this.atendimentoExame = atendimentoExame;
	}

	public List<AtendimentoMedicamento> getAtendimentoMedicamento() {
		return this.atendimentoMedicamento;
	}

	public void setAtendimentoMedicamento(List<AtendimentoMedicamento> atendimentoMedicamento) {
		this.atendimentoMedicamento = atendimentoMedicamento;
	}

	public List<AtendimentoSintoma> getAtendimentoSintoma() {
		return this.atendimentoSintoma;
	}

	public void setAtendimentoSintoma(List<AtendimentoSintoma> atendimentoSintoma) {
		this.atendimentoSintoma = atendimentoSintoma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Atendimento other = (Atendimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
