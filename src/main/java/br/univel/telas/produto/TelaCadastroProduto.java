package br.univel.telas.produto;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.univel.telalogin.MolduraAbstrata;

public class TelaCadastroProduto extends MolduraAbstrata {
	private static final long serialVersionUID = 1L;

	public TelaCadastroProduto() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new MioloCadastroProduto(), BorderLayout.CENTER);
	}

}
