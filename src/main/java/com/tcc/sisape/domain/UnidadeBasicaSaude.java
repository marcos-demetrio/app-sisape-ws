package com.tcc.sisape.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class UnidadeBasicaSaude {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("i_unidade_basica_saude")
	@Column(name = "i_unidade_basica_saude")
	private Long iUnidadeBasicaSaude;
	
	@Column(length = 255, nullable = false)
	private String nome;
		
	@JsonProperty("codigo_cnes")
	@Column(nullable = false)
	private Long codigoCnes;
	
	@CNPJ
	@Column(length = 14, nullable = false)
	private String cnpj;
	
	//private EsferaAdministrativa esferaAdministrativa;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_tipo_estabelecimento", referencedColumnName = "i_tipo_estabelecimento", nullable = false)
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
	
	@Column(length = 255, nullable = false)
	private String complemento;
	
	@Column(length = 255, nullable = false)
	private String pontoReferencia;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "i_cidade", referencedColumnName = "i_cidade", nullable = false)
	private Cidade cidade;

	@Column(length = 255, nullable = false)
	private String bairro;
	
	public Long getiUnidadeBasicaSaude() {
		return this.iUnidadeBasicaSaude;
	}

	public void setiUnidadeBasicaSaude(Long iUnidadeBasicaSaude) {
		this.iUnidadeBasicaSaude = iUnidadeBasicaSaude;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public UnidadeBasicaSaudeTipoEstabelecimento getTipoEstabelecimento() {
		return this.tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(UnidadeBasicaSaudeTipoEstabelecimento tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
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

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iUnidadeBasicaSaude == null) ? 0 : iUnidadeBasicaSaude.hashCode());
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
		if (iUnidadeBasicaSaude == null) {
			if (other.iUnidadeBasicaSaude != null)
				return false;
		} else if (!iUnidadeBasicaSaude.equals(other.iUnidadeBasicaSaude))
			return false;
		return true;
	}	
}
