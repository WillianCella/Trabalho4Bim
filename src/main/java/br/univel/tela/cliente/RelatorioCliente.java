package br.univel.tela.cliente;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import br.univel.Conexao;

public class RelatorioCliente {
	Conexao con = new Conexao();
	private static final String OUT_PDF = "out.pdf";
	private String arq = "C:\\Users\\Willian\\JaspersoftWorkspace\\MyReports\\Silhouette.jasper";
	JasperPrint jp = null;

	public RelatorioCliente() throws IOException {
		JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(arq, null,
					con.getConnection());
			JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
			jasperViewer.setVisible(true);
			jasperViewer
					.setDefaultCloseOperation(jasperViewer.DISPOSE_ON_CLOSE);
			jasperViewer.setExtendedState(jasperViewer.MAXIMIZED_BOTH);

			// NUullPointerException Verificar
			JasperExportManager.exportReportToPdfFile(jp, OUT_PDF);

			JOptionPane
					.showMessageDialog(
							null,
							"<html>Arquivo exportado para PDF!<br><br>A aplicação vai pedir"
									+ " ao Sistema operacional <br>para abrir com o visualizador"
									+ " padrão.");

			Desktop.getDesktop().open(new File(OUT_PDF));
		} catch (JRException ex) {
			ex.printStackTrace();
		}
		new ModelCliente();
	}
}
