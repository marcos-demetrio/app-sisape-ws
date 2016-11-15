package com.tcc.sisape.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tcc.sisape.domain.Atendimento;
import com.tcc.sisape.domain.AtendimentoSintoma;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class AtendimentoReport {
	private String pathToReportPackage;

	public AtendimentoReport() {
		this.pathToReportPackage = this.getClass().getClassLoader().getResource("").getPath() + "/jasper/";
	}

	public void imprimir(List<Atendimento> lista) throws Exception {
		Random rand = new Random();

		JasperReport report = JasperCompileManager
				.compileReport(this.getPathToReportPackage() + "reportAtendimento.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));

		JasperExportManager.exportReportToPdfFile(print, Math.abs(rand.nextInt()) + ".pdf");
	}

	public List<AdoecimentoReportData> getAdoecimento(List<Atendimento> lista) {
		boolean encontrouCid = false;
		List<AdoecimentoReportData> retorno = new ArrayList<AdoecimentoReportData>();

		for (Atendimento atendimento : lista) {
			String municipioNome = atendimento.getAgendamento().getProfissionalLotacao().getUnidadeBasicaSaude().getMunicipio().getNome();
			String unidadeBasicaSaudeNome = atendimento.getAgendamento().getProfissionalLotacao().getUnidadeBasicaSaude().getNome();

			List<AtendimentoSintoma> sintoma = atendimento.getAtendimentoSintoma();

			for (AtendimentoSintoma atendimentoSintoma : sintoma) {
				String cidCodigo = atendimentoSintoma.getCid().getCodigoCid();
				String cidDescricao = atendimentoSintoma.getCid().getDescricao();
				
				AdoecimentoReportData a = null;
				for (AdoecimentoReportData adoecimento : retorno) {
					if (adoecimento.getMunicipioNome() == municipioNome
							&& adoecimento.getUnidadeBasicaSaudeNome() == unidadeBasicaSaudeNome
							&& adoecimento.getCidCodigo() == cidCodigo
							&& adoecimento.getCidDescricao() == cidDescricao) {
						a = adoecimento;
						encontrouCid = true;
						break;
					} else {
						encontrouCid = false;
					}
				}

				if (encontrouCid) {
					a.addQuantidadeCasos();
				} else {
					a = new AdoecimentoReportData();
					a.setMunicipioNome(municipioNome);
					a.setUnidadeBasicaSaudeNome(unidadeBasicaSaudeNome);
					a.setCidCodigo(cidCodigo);
					a.setCidDescricao(cidDescricao);
					a.setQuantidadeCasos(1);
					retorno.add(a);
				}
			}
		}

		return retorno;
	}

	public void imprimirAdoecimento(List<Atendimento> lista) throws Exception {
		Random rand = new Random();

		List<AdoecimentoReportData> adoecimento = getAdoecimento(lista);

		JasperReport report = JasperCompileManager
				.compileReport(this.getPathToReportPackage() + "reportAdoecimento.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(adoecimento));

		JasperExportManager.exportReportToPdfFile(print, Math.abs(rand.nextInt()) + ".pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
}
