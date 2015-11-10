package br.univel.cadastro;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.univel.dao.ClienteDAO;

public class ClienteDAOImpl implements ClienteDAO {

	Conexao con = new Conexao();

	@Override
	public void inserir(Cliente c) {
		String sql = "INSERT INTO cliente ( NOME, FONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().toString());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().toString());

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Cliente c) {
		String sql = "UPDATE cliente SET NOME = ?, TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?, EMAIL = ?, GENERO = ? WHERE ID = ? ";
		try {
			PreparedStatement ps = con.getConnection().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().toString());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().toString());
			ps.setInt(8, c.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Cliente c) {
		String sql = "DELETE FROM cliente WHRERE ID = ?";
		try {
			PreparedStatement ps = con.getConnection().prepareStatement(sql);
			ps.setInt(1, c.getId());

			ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Cliente buscar(int idCliente) {
		Statement st = null;
		ResultSet result = null;
		try {
			try {
				st = (Statement) ((Connection) con).createStatement();
				result = ((java.sql.Statement) st)
						.executeQuery("SELECT * FROM PESSOA");
				while (result.next()) {
					int id = result.getInt(1);
					String nome = result.getString("nome");
					System.out.println(id + " " + nome);
				}
			} finally {
				if (st != null)
					((Connection) st).close();
				if (result != null)
					result.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
