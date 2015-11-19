package br.univel.telas.cliente;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTable;

public class TableListarCliente extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 * @author Willian Cella - 12/11/2015 - 20:09:57
	 */
	public TableListarCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable(new ModelCliente());
		scrollPane.setViewportView(table);
		
	}

}
