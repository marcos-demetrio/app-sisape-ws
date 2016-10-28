package com.tcc.sisape.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.sisape.domain.enumdados.EstadoCivil;
import com.tcc.sisape.domain.enumdados.GrauEscolaridade;
import com.tcc.sisape.domain.enumdados.RacaCor;
import com.tcc.sisape.domain.enumdados.Sexo;
import com.tcc.sisape.domain.enumdados.TipoSanguineo;

@Entity
public class Cidadao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_cidadao")
	@Column(name = "i_cidadao")
	private Long id;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 15)
	private String numeroCartaoNacionalSaude;

	@Column(nullable = false)
	private boolean possuiCartaoNacionalSaude;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 11)
	private String cpf;

	@Column(length = 100, nullable = false)
	private String nomeCompleto;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String nomeSocial;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNascimento;

	@Column(nullable = false)
	private boolean faleceu;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Sexo sexo;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private RacaCor racaCor;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String nomeMae;

	@Column(nullable = false)
	private boolean desconheceNomeMae;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_municipio_nascimento", referencedColumnName = "i_municipio", nullable = false)
	private Municipio municipioNascimento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude", nullable = false)
	private UnidadeBasicaSaude unidadeBasicaSaude;

	@Column(nullable = false)
	private boolean estrangeiro;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 8)
	private String cep;

	@JsonInclude(Include.NON_EMPTY)
	@ManyToOne
	@JoinColumn(name = "i_municipio", referencedColumnName = "i_municipio")
	private Municipio municipio;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String bairro;

	@JsonInclude(Include.NON_EMPTY)
	@ManyToOne
	@JoinColumn(name = "i_tipo_logradouro", referencedColumnName = "i_tipo_logradouro")
	private TipoLogradouro tipoLogradouro;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String logradouro;

	@JsonInclude(Include.NON_EMPTY)
	private Long numero;

	@Column(nullable = false)
	private boolean semNumero;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String complemento;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String pontoReferencia;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 20)
	private String telefoneResidencial;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 20)
	private String telefoneCelular;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 20)
	private String telefoneContato;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String email;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 32)
	private String senha;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 50)
	private String etnia;

	@JsonInclude(Include.NON_EMPTY)
	@Enumerated(EnumType.ORDINAL)
	private TipoSanguineo tipoSanguineo;

	@JsonInclude(Include.NON_EMPTY)
	@Enumerated(EnumType.ORDINAL)
	private EstadoCivil estadoCivil;

	@JsonInclude(Include.NON_EMPTY)
	@ManyToOne
	@JoinColumn(name = "i_cbo")
	private ClassificacaoBrasileiraOcupacao cbo;

	@JsonInclude(Include.NON_EMPTY)
	@Enumerated(EnumType.ORDINAL)
	private GrauEscolaridade escolaridade;

	@JsonInclude(Include.NON_EMPTY)
	private Long nisPisPasep;

	@JsonInclude(Include.NON_EMPTY)
	private Long numeroProntuario;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCartaoNacionalSaude() {
		return this.numeroCartaoNacionalSaude;
	}

	public void setNumeroCartaoNacionalSaude(String numeroCartaoNacionalSaude) {
		this.numeroCartaoNacionalSaude = numeroCartaoNacionalSaude;
	}

	public boolean isPossuiCartaoNacionalSaude() {
		return this.possuiCartaoNacionalSaude;
	}

	public void setPossuiCartaoNacionalSaude(boolean possuiCartaoNacionalSaude) {
		this.possuiCartaoNacionalSaude = possuiCartaoNacionalSaude;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return this.nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto.toUpperCase();
	}

	public String getNomeSocial() {
		return this.nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial.toUpperCase();
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isFaleceu() {
		return this.faleceu;
	}

	public void setFaleceu(boolean faleceu) {
		this.faleceu = faleceu;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public RacaCor getRacaCor() {
		return this.racaCor;
	}

	public void setRacaCor(RacaCor racaCor) {
		this.racaCor = racaCor;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae.toUpperCase();
	}

	public boolean isDesconheceNomeMae() {
		return this.desconheceNomeMae;
	}

	public void setDesconheceNomeMae(boolean desconheceNomeMae) {
		this.desconheceNomeMae = desconheceNomeMae;
	}

	public Municipio getMunicipioNascimento() {
		return this.municipioNascimento;
	}

	public void setMunicipioNascimento(Municipio municipioNascimento) {
		this.municipioNascimento = municipioNascimento;
	}

	public boolean isEstrangeiro() {
		return this.estrangeiro;
	}

	public void setEstrangeiro(boolean estrangeiro) {
		this.estrangeiro = estrangeiro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}

	public TipoLogradouro getTipoLogradouro() {
		return this.tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return this.numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public boolean isSemNumero() {
		return this.semNumero;
	}

	public void setSemNumero(boolean semNumero) {
		this.semNumero = semNumero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoReferencia() {
		return this.pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getTelefoneResidencial() {
		return this.telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return this.telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneContato() {
		return this.telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEtnia() {
		return this.etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public TipoSanguineo getTipoSanguineo() {
		return this.tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public ClassificacaoBrasileiraOcupacao getCbo() {
		return this.cbo;
	}

	public void setCbo(ClassificacaoBrasileiraOcupacao cbo) {
		this.cbo = cbo;
	}

	public GrauEscolaridade getEscolaridade() {
		return this.escolaridade;
	}

	public void setEscolaridade(GrauEscolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Long getNisPisPasep() {
		return this.nisPisPasep;
	}

	public void setNisPisPasep(Long nisPisPasep) {
		this.nisPisPasep = nisPisPasep;
	}

	public Long getNumeroProntuario() {
		return this.numeroProntuario;
	}

	public void setNumeroProntuario(Long numeroProntuario) {
		this.numeroProntuario = numeroProntuario;
	}

	public UnidadeBasicaSaude getUnidadeBasicaSaude() {
		return this.unidadeBasicaSaude;
	}

	public void setUnidadeBasicaSaude(UnidadeBasicaSaude unidadeBasicaSaude) {
		this.unidadeBasicaSaude = unidadeBasicaSaude;
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
		Cidadao other = (Cidadao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
