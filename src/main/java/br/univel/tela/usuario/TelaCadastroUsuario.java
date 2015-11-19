package br.univel.tela.usuario;

import java.awt.BorderLayout;
import java.sql.SQLException;
import br.univel.telalogin.MolduraAbstrata;

public class TelaCadastroUsuario extends MolduraAbstrata {
	private static final long serialVersionUID = 1L;

	public TelaCadastroUsuario() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new MioloCadastroUsuario(), BorderLayout.CENTER);
	}

}
