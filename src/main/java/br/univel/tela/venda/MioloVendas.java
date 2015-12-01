package br.univel.tela.venda;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MioloVendas extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txfCliente;
	private JTable table;
	private JTable table_1;
	private ModelVendas modelvendas;

	/**
	 * Create the panel.
	 */
	public MioloVendas() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelID = new JLabel("ID Cliente");
		GridBagConstraints gbc_labelID = new GridBagConstraints();
		gbc_labelID.insets = new Insets(0, 0, 5, 5);
		gbc_labelID.anchor = GridBagConstraints.EAST;
		gbc_labelID.gridx = 0;
		gbc_labelID.gridy = 0;
		add(labelID, gbc_labelID);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		GridBagConstraints gbc_btnBuscarCliente = new GridBagConstraints();
		gbc_btnBuscarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarCliente.gridx = 5;
		gbc_btnBuscarCliente.gridy = 0;
		add(btnBuscarCliente, gbc_btnBuscarCliente);

		txfCliente = new JTextField();
		GridBagConstraints gbc_txfCliente = new GridBagConstraints();
		gbc_txfCliente.gridwidth = 6;
		gbc_txfCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txfCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCliente.gridx = 0;
		gbc_txfCliente.gridy = 1;
		add(txfCliente, gbc_txfCliente);
		txfCliente.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnIncluir = new JButton(">>");
		GridBagConstraints gbc_btnIncluir = new GridBagConstraints();
		gbc_btnIncluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnIncluir.gridx = 6;
		gbc_btnIncluir.gridy = 2;
		add(btnIncluir, gbc_btnIncluir);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 8;
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 7;
		gbc_scrollPane_1.gridy = 2;
		add(scrollPane_1, gbc_scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		JButton btnRemover = new JButton("<<");
		GridBagConstraints gbc_btnRemover = new GridBagConstraints();
		gbc_btnRemover.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemover.gridx = 6;
		gbc_btnRemover.gridy = 4;
		add(btnRemover, gbc_btnRemover);
		
		modelvendas = new ModelVendas();
		table.setModel(modelvendas);
		
		txfCliente.setEnabled(false);

	}

}
