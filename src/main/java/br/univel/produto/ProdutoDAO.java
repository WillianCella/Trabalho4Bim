package br.univel.produto;

import java.util.List;

public interface ProdutoDAO {

	public void inserir(Produto p);

	public void atualizar(Produto p);

	public void excluir(Produto p);

	public Produto buscar(int id);

	public Produto buscarPorID(int id);

	public List<Produto> listar();
}
