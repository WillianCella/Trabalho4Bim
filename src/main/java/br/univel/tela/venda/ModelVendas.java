package br.univel.tela.venda;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.univel.produto.Produto;
import br.univel.produto.ProdutoDAOImpl;

public class ModelVendas extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	ProdutoDAOImpl pdao = new ProdutoDAOImpl();
	List<Produto> listaproduto = new ArrayList<>();

	public ModelVendas() {
		listaproduto = pdao.listar();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return listaproduto.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Produto p = (Produto) pdao.listar().get(row);

		switch (col) {

		case 0:
			return p.getId();
		case 1:
			return p.getCodigoBarra();
		case 2:
			return p.getCategoria();
		case 3:
			return p.getDescricao();
		case 4:
			return p.getUnidade();
		case 5:
			return p.getCusto();
		case 6:
			return p.getMargemLucro();
		default:
			return "Erro!";

		}
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {

		case 0:
			return "ID";
		case 1:
			return "Código de Barras";
		case 2:
			return "Categoria";
		case 3:
			return "Descrição";
		case 4:
			return "Unidade";
		case 5:
			return "Custo";
		case 6:
			return "Margem de Lucro";
		default:
			return "Erro!";

		}
	}
}
