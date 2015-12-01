package br.univel.tela.produto;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import br.univel.produto.Produto;
import br.univel.produto.ProdutoDAOImpl;

public class MioloCadastroProduto extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txfCodigoBarra;
	private JTextField txfCategoria;
	private JTextField txfDescricao;
	private JTextField txfUnidade;
	private JTextField txfCusto;
	private JTextField txfMargemLucro;
	private JTextField txfID;
	protected Produto produtoContexto;

	/**
	 * Create the panel.
	 */
	public MioloCadastroProduto() {
		if (produtoContexto == null) {
			produtoContexto = new Produto();
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 0;
		add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);

		txfCodigoBarra = new JTextField();
		GridBagConstraints gbc_txfCodigoBarra = new GridBagConstraints();
		gbc_txfCodigoBarra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCodigoBarra.insets = new Insets(0, 0, 5, 5);
		gbc_txfCodigoBarra.gridx = 1;
		gbc_txfCodigoBarra.gridy = 0;
		add(txfCodigoBarra, gbc_txfCodigoBarra);
		txfCodigoBarra.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 1;
		add(lblCategoria, gbc_lblCategoria);

		txfCategoria = new JTextField();
		GridBagConstraints gbc_txfCategoria = new GridBagConstraints();
		gbc_txfCategoria.gridwidth = 4;
		gbc_txfCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_txfCategoria.gridx = 1;
		gbc_txfCategoria.gridy = 1;
		add(txfCategoria, gbc_txfCategoria);
		txfCategoria.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 2;
		add(lblDescrio, gbc_lblDescrio);

		txfDescricao = new JTextField();
		GridBagConstraints gbc_txfDescricao = new GridBagConstraints();
		gbc_txfDescricao.gridwidth = 4;
		gbc_txfDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txfDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDescricao.gridx = 1;
		gbc_txfDescricao.gridy = 2;
		add(txfDescricao, gbc_txfDescricao);
		txfDescricao.setColumns(10);

		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.EAST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 3;
		add(lblUnidade, gbc_lblUnidade);

		txfUnidade = new JTextField();
		GridBagConstraints gbc_txfUnidade = new GridBagConstraints();
		gbc_txfUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_txfUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfUnidade.gridx = 1;
		gbc_txfUnidade.gridy = 3;
		add(txfUnidade, gbc_txfUnidade);
		txfUnidade.setColumns(10);

		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.EAST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 4;
		add(lblCusto, gbc_lblCusto);

		txfCusto = new JTextField();
		GridBagConstraints gbc_txfCusto = new GridBagConstraints();
		gbc_txfCusto.insets = new Insets(0, 0, 5, 5);
		gbc_txfCusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCusto.gridx = 1;
		gbc_txfCusto.gridy = 4;
		add(txfCusto, gbc_txfCusto);
		txfCusto.setColumns(10);

		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblMargemDeLucro = new GridBagConstraints();
		gbc_lblMargemDeLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMargemDeLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemDeLucro.gridx = 0;
		gbc_lblMargemDeLucro.gridy = 5;
		add(lblMargemDeLucro, gbc_lblMargemDeLucro);

		txfMargemLucro = new JTextField();
		GridBagConstraints gbc_txfMargemLucro = new GridBagConstraints();
		gbc_txfMargemLucro.insets = new Insets(0, 0, 5, 5);
		gbc_txfMargemLucro.anchor = GridBagConstraints.NORTH;
		gbc_txfMargemLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfMargemLucro.gridx = 1;
		gbc_txfMargemLucro.gridy = 5;
		add(txfMargemLucro, gbc_txfMargemLucro);
		txfMargemLucro.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}

			private void salvar() {
				ProdutoDAOImpl pdao = new ProdutoDAOImpl();
				produtoContexto.setCategoria(txfCategoria.getText());
				produtoContexto.setDescricao(txfDescricao.getText());
				produtoContexto.setUnidade(txfUnidade.getText());
				produtoContexto.setCusto(BigDecimal.valueOf(Double
						.valueOf(txfCusto.getText().replaceAll(",", "."))));
				produtoContexto.setMargemLucro(BigDecimal.valueOf(Double
						.valueOf(txfMargemLucro.getText().replaceAll(",", "."))));
				if (produtoContexto.getId() != 0) {
					limpar();
					pdao.atualizar(produtoContexto);
					return;
				}
				pdao.inserir(produtoContexto);
				limpar();
				txfID.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 6;
		add(btnSalvar, gbc_btnSalvar);

		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 0, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 8;
		add(lblId, gbc_lblId);

		txfID = new JTextField();
		GridBagConstraints gbc_txfID = new GridBagConstraints();
		gbc_txfID.anchor = GridBagConstraints.NORTH;
		gbc_txfID.insets = new Insets(0, 0, 0, 5);
		gbc_txfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfID.gridx = 1;
		gbc_txfID.gridy = 8;
		add(txfID, gbc_txfID);
		txfID.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarProduto();
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 8;
		add(btnBuscar, gbc_btnBuscar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirProduto();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 8;
		add(btnExcluir, gbc_btnExcluir);

	}

	protected void excluirProduto() {
		ProdutoDAOImpl pdao = new ProdutoDAOImpl();
		pdao.excluir(produtoContexto);
		limpar();
	}

	protected void buscarProduto() {
		txfID.setEnabled(false);
		ProdutoDAOImpl pdao = new ProdutoDAOImpl();

		int id = 0;
		if ((txfID.getText() == null) || (txfID.getText() == "")
				|| (txfID.getText().equals(0))) {
			JOptionPane
					.showMessageDialog(null, "ID inválido, Informe outro ID");
			return;
		}

		id = Integer.parseInt(txfID.getText());
		produtoContexto = pdao.buscarPorID(id);
		txfCodigoBarra
				.setText(String.valueOf(produtoContexto.getCodigoBarra()));
		txfCategoria.setText(produtoContexto.getCategoria());
		txfDescricao.setText(produtoContexto.getDescricao());
		txfUnidade.setText(produtoContexto.getUnidade());
		txfCusto.setText(String.valueOf(produtoContexto.getCusto()));
		txfMargemLucro
				.setText(String.valueOf(produtoContexto.getMargemLucro()));
		txfID.setEnabled(true);
	}

	protected void limpar() {
		txfCodigoBarra.setText("");
		txfCategoria.setText("");
		txfDescricao.setText("");
		txfUnidade.setText("");
		txfCusto.setText("");
		txfMargemLucro.setText("");
	}

}
