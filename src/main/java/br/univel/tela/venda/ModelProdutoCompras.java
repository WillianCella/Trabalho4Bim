package br.univel.tela.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import br.univel.produto.Produto;

public class ModelProdutoCompras extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	List<Produto> lista = new ArrayList<>();
	Map<String, BigDecimal> mapValor = new HashMap<>();
	Map<String, BigDecimal> mapQuantidade = new HashMap<>();

	public void addNovoProduto(Produto produto, BigDecimal valorTotal,
			BigDecimal quantidade) {
		lista.add(produto);
		mapValor.put(produto.getDescricao(), valorTotal);
		mapQuantidade.put(produto.getDescricao(), quantidade);
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Produto p = lista.get(row);

		switch (col) {
		case 0:
			return p.getDescricao();
		case 1:
			return mapValor.get(p.getDescricao()).toString();
		case 2:
			return mapQuantidade.get(p.getDescricao());
		default:
			return "Inesperado!";
		}
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {

		case 0:
			return "Produto";
		case 1:
			return "Valor";
		case 2:
			return "Quantidade";
		default:
			return "Erro!";

		}
	}

}
