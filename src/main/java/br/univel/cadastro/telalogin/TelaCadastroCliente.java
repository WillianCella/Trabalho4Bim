package br.univel.cadastro.telalogin;

import java.awt.BorderLayout;
import java.sql.SQLException;

public class TelaCadastroCliente extends MolduraAbstrata {
	private static final long serialVersionUID = 1L;

	public TelaCadastroCliente() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new MioloCadastroCliente(), BorderLayout.CENTER);
	}

}
