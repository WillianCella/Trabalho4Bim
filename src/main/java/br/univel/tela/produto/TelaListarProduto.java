package br.univel.tela.produto;

import java.awt.BorderLayout;
import java.sql.SQLException;
import br.univel.telalogin.MolduraAbstrata;

public class TelaListarProduto extends MolduraAbstrata {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public TelaListarProduto() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new TableListarProduto(), BorderLayout.CENTER);

	}

}
