package br.univel.cadastro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		Cliente c = new Cliente();
		PreparedStatement st = null;
		ResultSet result = null;
		String sql = ("SELECT * FROM cliente WHERE id = " + idCliente);
		try {
			st = con.getConnection().prepareStatement(sql);
			result = st.executeQuery();
			while (result.next()) {
				c.setId(idCliente);
				c.setNome(result.getString("nome"));
				c.setTelefone(result.getString("fone"));
				c.setEndereco(result.getString("endereco"));
				c.setCidade(result.getString("cidade"));
				c.setEstado(Estado.valueOf(result.getString("estado")));
				c.setEmail(result.getString("email"));
				c.setGenero(Genero.valueOf(result.getString("genero")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Cliente> consultar() {
		List<Cliente> lista = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet result = null;
		String sql = ("SELECT * FROM cliente");
		try {
			st = con.getConnection().prepareStatement(sql);
			result = st.executeQuery();
			while (result.next()) {
				Cliente c = new Cliente();
				c.setId(result.getInt("id"));
				c.setNome(result.getString("nome"));
				c.setTelefone(result.getString("fone"));
				c.setEndereco(result.getString("endereco"));
				c.setCidade(result.getString("cidade"));
				c.setEstado(Estado.valueOf(result.getString("estado")));
				c.setEmail(result.getString("email"));
				c.setGenero(Genero.valueOf(result.getString("genero")));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet result = null;
		String sql = ("SELECT * FROM cliente");
		try {
			st = con.getConnection().prepareStatement(sql);
			result = st.executeQuery();
			while (result.next()) {
				Cliente c = new Cliente();
				c.setId(result.getInt("id"));
				c.setNome(result.getString("nome"));
				c.setTelefone(result.getString("fone"));
				c.setEndereco(result.getString("endereco"));
				c.setCidade(result.getString("cidade"));
				c.setEstado(Estado.valueOf(result.getString("estado")));
				c.setEmail(result.getString("email"));
				c.setGenero(Genero.valueOf(result.getString("genero")));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void buscarPorID(int id) {

	}

}
