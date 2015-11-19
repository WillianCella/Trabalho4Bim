package br.univel.tela.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDAOImpl;

public class ModelCliente extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	ClienteDAOImpl cdao = new ClienteDAOImpl();

	List<Cliente> lista = new ArrayList<>();

	public ModelCliente() {
		lista = cdao.listar();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Cliente c = (Cliente) cdao.listar().get(row);

		switch (col) {

		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getEndereco();
		case 3:
			return c.getTelefone();
		case 4:
			return c.getCidade();
		case 5:
			return c.getEstado();
		case 6:
			return c.getGenero();
		case 7:
			return c.getEmail();
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
			return "Nome";
		case 2:
			return "Endere�o";
		case 3:
			return "Telefone";
		case 4:
			return "Cidade";
		case 5:
			return "Estado";
		case 6:
			return "G�nero";
		case 7:
			return "Email";
		default:
			return "Erro!";

		}
	}

}
