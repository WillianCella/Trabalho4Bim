package br.univel.usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Conexao;
import br.univel.cliente.Cliente;

public class UsuarioDAOImpl implements UsuarioDAO {

	Conexao con = new Conexao();

	@Override
	public void inserir(Usuario u) {
		String sql = "INSERT INTO USUARIO (cliente_idcliente, senha) VALUES (?, ?)";

		try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
			ps.setInt(1, u.getId());
			ps.setString(2, u.getSenha().toString());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario buscar(int id) {
		Usuario u = new Usuario();
		Cliente c = new Cliente();
		PreparedStatement st = null;
		ResultSet result = null;
		String sql = ("SELECT * FROM cliente WHERE idcliente = " + id);
		try {
			st = con.getConnection().prepareStatement(sql);
			result = st.executeQuery();
			while (result.next()) {
				u.setId(id);
				c.setNome(result.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Usuario buscarPorID(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
