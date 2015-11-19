package br.univel.usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.univel.Conexao;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	Conexao con = new Conexao();

	@Override
	public void inserir(Usuario u) {
		String sql = "INSERT INTO USUARIO (cliente_idcliente, senha) VALUES (?, ?)";

		try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
			ps.setInt(1, u.getId());
			ps.setString(2, u.getSenha().toString());

			ps.executeUpdate();

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
		// TODO Auto-generated method stub
		return null;
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
