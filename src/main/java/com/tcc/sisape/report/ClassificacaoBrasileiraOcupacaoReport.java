package com.tcc.sisape.report;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

	public void imprimir(HttpServletResponse response, List<ClassificacaoBrasileiraOcupacao> lista) throws Exception {
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "reportCBO.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=cbo.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(print, outStream);
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
}
