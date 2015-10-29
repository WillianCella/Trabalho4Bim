package br.univel.cadastro.telalogin;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MioloCadastroCliente extends JPanel {
	private static final long serialVersionUID = 1L;

	protected JTextField txfId;
	protected JTextField txfNome;
	private JTextField txfTelefone;
	private JLabel lblTelefone;
	private JTextField txfEndereco;
	private JTextField txfCidade;
	private JTextField tsxfEmail;
	private JComboBox cbxEstado;
	private JComboBox cbxGenero;
	private JLabel lblEndereo;
	private JLabel lblCidade;
	private JLabel lblEmail;
	private JLabel lblEstado;
	private JLabel lblGnero;

	/**
	 * Create the panel.
	 */
	public MioloCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 64, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);

		txfId = new JTextField();
		GridBagConstraints gbc_txfId = new GridBagConstraints();
		gbc_txfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfId.insets = new Insets(0, 0, 5, 5);
		gbc_txfId.gridx = 1;
		gbc_txfId.gridy = 0;
		add(txfId, gbc_txfId);
		txfId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.gridwidth = 3;
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 1;
		add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);
		
		lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 2;
		add(lblTelefone, gbc_lblTelefone);
		
		txfTelefone = new JTextField();
		GridBagConstraints gbc_txfTelefone = new GridBagConstraints();
		gbc_txfTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txfTelefone.gridx = 1;
		gbc_txfTelefone.gridy = 2;
		add(txfTelefone, gbc_txfTelefone);
		txfTelefone.setColumns(10);
		
		lblGnero = new JLabel("G\u00EAnero");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 2;
		gbc_lblGnero.gridy = 2;
		add(lblGnero, gbc_lblGnero);
		
		cbxGenero = new JComboBox();
		GridBagConstraints gbc_cbxGenero = new GridBagConstraints();
		gbc_cbxGenero.anchor = GridBagConstraints.WEST;
		gbc_cbxGenero.insets = new Insets(0, 0, 5, 0);
		gbc_cbxGenero.gridx = 3;
		gbc_cbxGenero.gridy = 2;
		add(cbxGenero, gbc_cbxGenero);
		
		lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 3;
		add(lblEndereo, gbc_lblEndereo);
		
		txfEndereco = new JTextField();
		GridBagConstraints gbc_txfEndereco = new GridBagConstraints();
		gbc_txfEndereco.gridwidth = 3;
		gbc_txfEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_txfEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfEndereco.gridx = 1;
		gbc_txfEndereco.gridy = 3;
		add(txfEndereco, gbc_txfEndereco);
		txfEndereco.setColumns(10);
		
		lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 4;
		add(lblCidade, gbc_lblCidade);
		
		txfCidade = new JTextField();
		GridBagConstraints gbc_txfCidade = new GridBagConstraints();
		gbc_txfCidade.gridwidth = 3;
		gbc_txfCidade.insets = new Insets(0, 0, 5, 0);
		gbc_txfCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCidade.gridx = 1;
		gbc_txfCidade.gridy = 4;
		add(txfCidade, gbc_txfCidade);
		txfCidade.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		add(lblEstado, gbc_lblEstado);
		
		cbxEstado = new JComboBox();
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		gbc_cbxEstado.anchor = GridBagConstraints.WEST;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstado.gridx = 1;
		gbc_cbxEstado.gridy = 5;
		add(cbxEstado, gbc_cbxEstado);
		
		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		add(lblEmail, gbc_lblEmail);
		
		tsxfEmail = new JTextField();
		GridBagConstraints gbc_tsxfEmail = new GridBagConstraints();
		gbc_tsxfEmail.gridwidth = 3;
		gbc_tsxfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tsxfEmail.gridx = 1;
		gbc_tsxfEmail.gridy = 7;
		add(tsxfEmail, gbc_tsxfEmail);
		tsxfEmail.setColumns(10);

	}

}
