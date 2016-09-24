package com.tcc.sisape.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.sisape.domain.enumdados.EsferaAdministrativa;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UnidadeBasicaSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_unidade_basica_saude")
	@Column(name = "i_unidade_basica_saude")
	private Long id;

	@Column(length = 255, nullable = false)
	private String nome;

	@JsonProperty("codigo_cnes")
	@Column(nullable = false)
	private Long codigoCnes;

	@CNPJ
	@Column(length = 14)
	private String cnpj;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 17)
	private EsferaAdministrativa esferaAdministrativa;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_unidade_basica_saude_tipo_estabelecimento", referencedColumnName = "i_unidade_basica_saude_tipo_estabelecimento", nullable = false)
	private UnidadeBasicaSaudeTipoEstabelecimento tipoEstabelecimento;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 12)
	private String telefonePrincipal;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 12)
	private String telefoneSecundario;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 12)
	private String telefoneFax;

	@Email
	@Column(length = 255, nullable = false)
	private String email;

	@Column(length = 8, nullable = false)
	private String cep;

	@Column(length = 255, nullable = false)
	private String logradouro;

	@JsonInclude(Include.NON_EMPTY)
	private Long numero;

	@Column(nullable = false)
	private boolean semNumero;

	@JsonInclude(Include.NON_EMPTY)
	@Column(length = 100)
	private String bairro;

	@Column(length = 255, nullable = false)
	private String complemento;

	@Column(length = 255, nullable = false)
	private String pontoReferencia;

	@Column(nullable = false)
	private boolean ativo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "i_municipio", referencedColumnName = "i_municipio", nullable = false)
	private Municipio municipio;

	@OneToMany(mappedBy = "unidadeBasicaSaude", cascade = CascadeType.ALL)
	private Set<UnidadeBasicaSaudeZonaAtendimento> zonaAtendimento;

	@OneToOne(mappedBy = "unidadeBasicaSaude", cascade = CascadeType.ALL)
	private UnidadeBasicaSaudeParametro parametroUbs;

	public Long getId() {
		return this.id;
	}

	public void setId(Long aId) {
		this.id = aId;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public Long getCodigoCnes() {
		return this.codigoCnes;
	}

	public void setCodigoCnes(Long codigoCnes) {
		this.codigoCnes = codigoCnes;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefonePrincipal() {
		return this.telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneSecundario() {
		return this.telefoneSecundario;
	}

	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}

	public String getTelefoneFax() {
		return this.telefoneFax;
	}

	public void setTelefoneFax(String telefoneFax) {
		this.telefoneFax = telefoneFax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setCidade(Municipio aMunicipio) {
		this.municipio = aMunicipio;
	}

	public EsferaAdministrativa getEsferaAdministrativa() {
		return this.esferaAdministrativa;
	}

	public void setEsferaAdministrativa(EsferaAdministrativa esferaAdministrativa) {
		this.esferaAdministrativa = esferaAdministrativa;
	}

	public Set<UnidadeBasicaSaudeZonaAtendimento> getZonaAtendimento() {
		return this.zonaAtendimento;
	}

	public void setZonaAtendimento(Set<UnidadeBasicaSaudeZonaAtendimento> zonaAtendimento) {
		this.zonaAtendimento = zonaAtendimento;
	}

	public UnidadeBasicaSaudeParametro getParametroUbs() {
		return this.parametroUbs;
	}

	public void setParametroUbs(UnidadeBasicaSaudeParametro parametroUbs) {
		this.parametroUbs = parametroUbs;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public UnidadeBasicaSaudeTipoEstabelecimento getTipoEstabelecimento() {
		return this.tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(UnidadeBasicaSaudeTipoEstabelecimento tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}

	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean aAtivo) {
		this.ativo = aAtivo;
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
		UnidadeBasicaSaude other = (UnidadeBasicaSaude) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
