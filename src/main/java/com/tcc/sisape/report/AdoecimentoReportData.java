package com.tcc.sisape.report;

public class AdoecimentoReportData {

	private String municipioNome;
	private String unidadeBasicaSaudeNome;
	private String cidCodigo;
	private String cidDescricao;
	private int quantidadeCasos;

	public String getMunicipioNome() {
		return municipioNome;
	}

	public void setMunicipioNome(String municipioNome) {
		this.municipioNome = municipioNome;
	}

	public String getUnidadeBasicaSaudeNome() {
		return unidadeBasicaSaudeNome;
	}

	public void setUnidadeBasicaSaudeNome(String unidadeBasicaSaudeNome) {
		this.unidadeBasicaSaudeNome = unidadeBasicaSaudeNome;
	}

	public String getCidCodigo() {
		return cidCodigo;
	}

	public void setCidCodigo(String cidCodigo) {
		this.cidCodigo = cidCodigo;
	}

	public String getCidDescricao() {
		return cidDescricao;
	}

	public void setCidDescricao(String cidDescricao) {
		this.cidDescricao = cidDescricao;
	}

	public int getQuantidadeCasos() {
		return quantidadeCasos;
	}

	public void setQuantidadeCasos(int quantidadeCasos) {
		this.quantidadeCasos = quantidadeCasos;
	}

	public void addQuantidadeCasos() {
		this.setQuantidadeCasos(this.getQuantidadeCasos() + 1);
	}
}
