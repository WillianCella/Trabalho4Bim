package br.univel.tela.venda;

import java.awt.BorderLayout;
import java.sql.SQLException;
import br.univel.telalogin.MolduraAbstrata;

public class TelaVender extends MolduraAbstrata {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public TelaVender() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new MioloVendas(), BorderLayout.CENTER);
	}

}
