package com.tcc.sisape.report;

import java.util.List;
import java.util.Random;

import com.tcc.sisape.domain.ClassificacaoBrasileiraOcupacao;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ClassificacaoBrasileiraOcupacaoReport {
	private String pathToReportPackage;

	public ClassificacaoBrasileiraOcupacaoReport() {
		this.pathToReportPackage = this.getClass().getClassLoader().getResource("").getPath() + "/jasper/";
	}

	public void imprimir(List<ClassificacaoBrasileiraOcupacao> lista) throws Exception {
		Random rand = new Random();

		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "reportCBO.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));

		JasperExportManager.exportReportToPdfFile(print, Math.abs(rand.nextInt()) + ".pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
}
