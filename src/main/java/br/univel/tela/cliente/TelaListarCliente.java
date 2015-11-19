package br.univel.tela.cliente;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.univel.telalogin.MolduraAbstrata;

public class TelaListarCliente extends MolduraAbstrata {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaListarCliente() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new TableListarCliente(), BorderLayout.CENTER);
	}

}
