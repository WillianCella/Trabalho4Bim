package br.univel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.univel.cadastro.Cliente;
import br.univel.cadastro.Conexao;

public class ClienteDAOImpl implements ClienteDAO {

	Conexao conexao = new Conexao();

	@Override
	public void inserir(Cliente c) {
		String sql = "INSERT INTO CLIENTE ( NOME, FONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = conexao.getConnection().prepareStatement(
				sql)) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Cliente c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
