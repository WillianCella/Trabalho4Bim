package br.univel.tela.venda;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;
import br.univel.produto.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MioloVendas extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txfCliente;
	private JTable table;
	private JTable table_1;
	private ModelVendas modelvendas;
	private JTextField txfID;
	protected Cliente clientecontexto;
	BigDecimal label = new BigDecimal(0);
	private ModelProdutoCompras mpc = new ModelProdutoCompras();

	/**
	 * Create the panel.
	 */
	public MioloVendas() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
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

		txfID = new JTextField();
		GridBagConstraints gbc_txfID = new GridBagConstraints();
		gbc_txfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfID.gridwidth = 4;
		gbc_txfID.insets = new Insets(0, 0, 5, 5);
		gbc_txfID.gridx = 1;
		gbc_txfID.gridy = 0;
		add(txfID, gbc_txfID);
		txfID.setColumns(10);

		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAOImpl cdao = new ClienteDAOImpl();
				int id = 0;
				if ((txfID.getText() == null) || (txfID.getText() == "")
						|| (txfID.getText().equals(0))) {
					JOptionPane.showMessageDialog(null,
							"ID inválido, Informe outro ID");
					return;
				}

				id = Integer.parseInt(txfID.getText());
				clientecontexto = cdao.buscarPorID(id);
				txfCliente.setText(clientecontexto.getNome());
			}
		});
		GridBagConstraints gbc_btnBuscarCliente = new GridBagConstraints();
		gbc_btnBuscarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarCliente.gridx = 5;
		gbc_btnBuscarCliente.gridy = 0;
		add(btnBuscarCliente, gbc_btnBuscarCliente);

		JLabel lblValorTotal = new JLabel("Valor Total");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.gridwidth = 2;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridx = 9;
		gbc_lblValorTotal.gridy = 0;
		add(lblValorTotal, gbc_lblValorTotal);

		JLabel lblValorTotal1 = new JLabel("");
		GridBagConstraints gbc_lblValorTotal1 = new GridBagConstraints();
		gbc_lblValorTotal1.gridwidth = 3;
		gbc_lblValorTotal1.insets = new Insets(0, 0, 5, 0);
		gbc_lblValorTotal1.gridx = 12;
		gbc_lblValorTotal1.gridy = 0;
		add(lblValorTotal1, gbc_lblValorTotal1);

		txfCliente = new JTextField();
		GridBagConstraints gbc_txfCliente = new GridBagConstraints();
		gbc_txfCliente.gridwidth = 6;
		gbc_txfCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txfCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCliente.gridx = 0;
		gbc_txfCliente.gridy = 1;
		add(txfCliente, gbc_txfCliente);
		txfCliente.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.gridwidth = 3;
		gbc_btnGravar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGravar.gridx = 12;
		gbc_btnGravar.gridy = 1;
		add(btnGravar, gbc_btnGravar);

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
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int item = table.getSelectedRow();
				Produto p = modelvendas.listaproduto.get(item);
				BigDecimal quantidade = (BigDecimal.valueOf(Double.valueOf(JOptionPane.showInputDialog(null,"Informe a quntidade"))));
				BigDecimal preco = p.getMargemLucro().divide(p.getCusto(),RoundingMode.HALF_UP);
				BigDecimal precoFinal = p.getCusto().multiply(quantidade);
				BigDecimal valorTotal = preco.add(precoFinal);

				mpc.addNovoProduto(p, valorTotal, quantidade);
				label = label.add(valorTotal); 
				lblValorTotal1.setText(String.valueOf(label));
				
			}
		});
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
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Botão Remover
			}
		});
		GridBagConstraints gbc_btnRemover = new GridBagConstraints();
		gbc_btnRemover.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemover.gridx = 6;
		gbc_btnRemover.gridy = 4;
		add(btnRemover, gbc_btnRemover);

		modelvendas = new ModelVendas();
		table.setModel(modelvendas);

		txfCliente.setEnabled(false);

		table_1.setModel(mpc);

	}

}
