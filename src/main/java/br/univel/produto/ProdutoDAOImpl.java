package br.univel.produto;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.univel.Conexao;

public class ProdutoDAOImpl implements ProdutoDAO {

	Conexao con = new Conexao();

	@Override
	public void inserir(Produto p) {
		String sql = "INSERT INTO produto (codigobarra, categoria, descricao, unidade, custo, lucro) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {
			ps.setInt(1, p.getCodigoBarra());
			ps.setString(2, p.getCategoria());
			ps.setString(3, p.getDescricao());
			ps.setString(4, p.getUnidade().toString());
			ps.setBigDecimal(5, p.getCusto());
			ps.setBigDecimal(6, p.getMargemLucro());

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Produto p) {
		String sql = "UPDATE produto SET codigobarra = ?,  categoria = ?, descricao = ?, unidade = ?, custo = ?, lucro = ? WHERE idproduto = ?";
		try {
			PreparedStatement ps = con.getConnection().prepareStatement(sql);
			ps.setInt(1, p.getCodigoBarra());
			ps.setString(2, p.getCategoria());
			ps.setString(3, p.getDescricao());
			ps.setString(4, p.getUnidade().toString());
			ps.setBigDecimal(5, p.getCusto());
			ps.setBigDecimal(6, p.getMargemLucro());

			ps.setInt(7, p.getId());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Produto p) {
		String sql = "DELETE FROM produto WHERE idproduto = " + p.getId();
		try {
			int opcao = JOptionPane.YES_NO_OPTION;
			JOptionPane.showConfirmDialog(null, "Você tem certeza?",
					"Atenção!", opcao);
			if (opcao == JOptionPane.YES_OPTION) {
				PreparedStatement ps = con.getConnection()
						.prepareStatement(sql);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Produto Excluído!");
				ps.close();
			}
			if (opcao == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto buscar(int idProduto) {
		Produto p = new Produto();
		PreparedStatement st = null;
		ResultSet result = null;
		String sql = ("SELECT * FROM produto WHERE idproduto = " + idProduto);
		try {
			st = con.getConnection().prepareStatement(sql);
			result = st.executeQuery();
			while (result.next()) {
				p.setId(idProduto);
				p.setCodigoBarra(result.getInt("codigobarra"));
				p.setCategoria(result.getString("categoria"));
				p.setDescricao(result.getString("descricao"));
				p.setUnidade(result.getString("unidade"));
				p.setCusto(new BigDecimal(result.getString("unidade")));
				p.setMargemLucro(new BigDecimal(result.getString("lucro")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produto buscarPorID(int id) {
		PreparedStatement st = null;
		ResultSet result = null;
		String sql = "SELECT * FROM produto WHERE idproduto = " + id;
		Produto p = new Produto();
		try {
			st = con.getConnection().prepareStatement(sql);
			result = st.executeQuery();
			while (result.next()) {
				p.setId(id);
				p.setCodigoBarra(result.getInt("codigobarra"));
				p.setCategoria(result.getString("categoria"));
				p.setDescricao(result.getString("descricao"));
				p.setUnidade(result.getString("unidade"));
				p.setCusto(BigDecimal.valueOf(Double.valueOf(result
						.getString("custo"))));
				p.setMargemLucro(BigDecimal.valueOf(Double.valueOf(result
						.getString("lucro"))));
			}
			con.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produto> listar() {
		PreparedStatement st = null;
		ResultSet result = null;
		String sql = "SELECT * FROM produto";
		List<Produto> lista = new ArrayList<>();
		Produto p;
		try {
			try {
				st = con.getConnection().prepareStatement(sql);
				result = st.executeQuery();

				while (result.next()) {
					p = new Produto();
					p.setId(result.getInt("idproduto"));
					p.setCodigoBarra(result.getInt("codigobarra"));
					p.setCategoria(result.getString("categoria"));
					p.setDescricao(result.getString("descricao"));
					p.setUnidade(result.getString("unidade"));
					p.setCusto(BigDecimal.valueOf(Double.valueOf(result
							.getString("custo"))));
					p.setMargemLucro(BigDecimal.valueOf(Double.valueOf(result
							.getString("lucro"))));
					lista.add(p);
				}
			} finally {
				if (st != null)
					st.close();
				if (result != null)
					result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
