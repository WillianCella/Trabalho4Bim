package br.univel.telas.cliente;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import br.univel.Conexao;
import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.cliente.Estado;
import br.univel.cliente.Genero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class MioloCadastroCliente extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JTextField txfNome;
	protected JTextField txfTelefone;
	protected JLabel lblTelefone;
	protected JTextField txfEndereco;
	protected JTextField txfCidade;
	protected JTextField txfEmail;
	protected JComboBox cbxEstado;
	protected JComboBox cbxGenero;
	protected JLabel lblEndereo;
	protected JLabel lblCidade;
	protected JLabel lblEmail;
	protected JLabel lblEstado;
	protected JLabel lblGnero;
	protected JButton btnSalvar;
	protected JTextField txfIdEditar;
	protected JButton btnBuscar;
	protected JButton btnExcluir;
	protected JLabel lblId_1;
	protected Cliente clienteContexto;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public MioloCadastroCliente() throws SQLException {

		if (clienteContexto == null) {
			clienteContexto = new Cliente();
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 64, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.gridwidth = 3;
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 2;
		gbc_txfNome.gridy = 1;
		add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);

		lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 2;
		add(lblTelefone, gbc_lblTelefone);

		txfTelefone = new JTextField();
		GridBagConstraints gbc_txfTelefone = new GridBagConstraints();
		gbc_txfTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txfTelefone.gridx = 2;
		gbc_txfTelefone.gridy = 2;
		add(txfTelefone, gbc_txfTelefone);
		txfTelefone.setColumns(10);

		lblGnero = new JLabel("G\u00EAnero");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 3;
		gbc_lblGnero.gridy = 2;
		add(lblGnero, gbc_lblGnero);

		cbxGenero = new JComboBox(Genero.values());
		GridBagConstraints gbc_cbxGenero = new GridBagConstraints();
		gbc_cbxGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxGenero.insets = new Insets(0, 0, 5, 0);
		gbc_cbxGenero.gridx = 4;
		gbc_cbxGenero.gridy = 2;
		add(cbxGenero, gbc_cbxGenero);

		lblEndereo = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 3;
		add(lblEndereo, gbc_lblEndereo);

		txfEndereco = new JTextField();
		GridBagConstraints gbc_txfEndereco = new GridBagConstraints();
		gbc_txfEndereco.gridwidth = 3;
		gbc_txfEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_txfEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfEndereco.gridx = 2;
		gbc_txfEndereco.gridy = 3;
		add(txfEndereco, gbc_txfEndereco);
		txfEndereco.setColumns(10);

		lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 4;
		add(lblCidade, gbc_lblCidade);

		txfCidade = new JTextField();
		GridBagConstraints gbc_txfCidade = new GridBagConstraints();
		gbc_txfCidade.gridwidth = 3;
		gbc_txfCidade.insets = new Insets(0, 0, 5, 0);
		gbc_txfCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCidade.gridx = 2;
		gbc_txfCidade.gridy = 4;
		add(txfCidade, gbc_txfCidade);
		txfCidade.setColumns(10);

		lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		add(lblEstado, gbc_lblEstado);

		cbxEstado = new JComboBox(Estado.values());
		GridBagConstraints gbc_cbxEstado = new GridBagConstraints();
		gbc_cbxEstado.anchor = GridBagConstraints.WEST;
		gbc_cbxEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEstado.gridx = 2;
		gbc_cbxEstado.gridy = 5;
		add(cbxEstado, gbc_cbxEstado);

		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		add(lblEmail, gbc_lblEmail);

		txfEmail = new JTextField();
		GridBagConstraints gbc_txfEmail = new GridBagConstraints();
		gbc_txfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txfEmail.gridwidth = 3;
		gbc_txfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfEmail.gridx = 2;
		gbc_txfEmail.gridy = 7;
		add(txfEmail, gbc_txfEmail);
		txfEmail.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}

			private void salvar() {
				txfIdEditar.setEnabled(true);
				ClienteDAOImpl cdao = new ClienteDAOImpl();

				clienteContexto.setNome(txfNome.getText());
				clienteContexto.setTelefone(txfTelefone.getText());
				clienteContexto.setEndereco(txfEndereco.getText());
				clienteContexto.setCidade(txfCidade.getText());
				clienteContexto.setEstado((Estado) cbxEstado.getSelectedItem());
				clienteContexto.setEmail(txfEmail.getText());
				clienteContexto.setGenero((Genero) cbxGenero.getSelectedItem());

				if (clienteContexto.getId() != 0) {
					limpar();
					cdao.atualizar(clienteContexto);
					return;
				}
				cdao.inserir(clienteContexto);

				limpar();
				txfIdEditar.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalvar.gridx = 2;
		gbc_btnSalvar.gridy = 8;
		add(btnSalvar, gbc_btnSalvar);

		lblId_1 = new JLabel("ID");
		GridBagConstraints gbc_lblId_1 = new GridBagConstraints();
		gbc_lblId_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblId_1.anchor = GridBagConstraints.EAST;
		gbc_lblId_1.gridx = 1;
		gbc_lblId_1.gridy = 9;
		add(lblId_1, gbc_lblId_1);

		txfIdEditar = new JTextField();
		GridBagConstraints gbc_txfIdEditar = new GridBagConstraints();
		gbc_txfIdEditar.insets = new Insets(0, 0, 0, 5);
		gbc_txfIdEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfIdEditar.gridx = 2;
		gbc_txfIdEditar.gridy = 9;
		add(txfIdEditar, gbc_txfIdEditar);
		txfIdEditar.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 9;
		add(btnBuscar, gbc_btnBuscar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAOImpl cdao = new ClienteDAOImpl();
				cdao.excluir(clienteContexto);
				limpar();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 9;
		add(btnExcluir, gbc_btnExcluir);

	}

	protected void buscarCliente() {
		txfIdEditar.setEnabled(false);
		ClienteDAOImpl cdao = new ClienteDAOImpl();

		int id = 0;
		if ((txfIdEditar.getText() == null) || (txfIdEditar.getText() == "")
				|| (txfIdEditar.getText().equals(0))) {
			JOptionPane
					.showMessageDialog(null, "ID inválido, Informe outro ID");
			return;
		}

		id = Integer.parseInt(txfIdEditar.getText());
		clienteContexto = cdao.buscarPorID(id);
		txfNome.setText(clienteContexto.getNome());
		txfTelefone.setText(clienteContexto.getTelefone());
		txfEndereco.setText(clienteContexto.getEndereco());
		txfCidade.setText(clienteContexto.getCidade());
		txfEmail.setText(clienteContexto.getEmail());
		cbxEstado.setSelectedItem(clienteContexto.getEstado());
		cbxGenero.setSelectedItem(clienteContexto.getGenero());

	}

	protected void limpar() {
		txfNome.setText("");
		txfCidade.setText("");
		txfEmail.setText("");
		txfEndereco.setText("");
		txfTelefone.setText("");
		cbxEstado.setSelectedIndex(0);
		cbxGenero.setSelectedIndex(0);
	}

}
