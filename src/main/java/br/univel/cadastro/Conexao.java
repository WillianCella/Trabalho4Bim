package br.univel.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private Connection conexao;

	public Connection getcConnection() {
		if (conexao == null)
			try {
				abrirconexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return conexao;
	}

	private void abrirconexao() throws SQLException {
		String url = "jdbc:postgresql://127.0.0.1:5432/Trabalho4BimJava";
		String user = "postgres";
		String pass = "postgres";
		conexao = DriverManager.getConnection(url, user, pass);
	}
}
