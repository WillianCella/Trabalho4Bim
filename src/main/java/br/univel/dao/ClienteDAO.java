package br.univel.dao;

import java.util.List;

import br.univel.cadastro.Cliente;

/**
 * 
 * @author Willian Cella - 03/11/2015 - 20:39:24
 *
 */

public interface ClienteDAO {

	public void inserir(Cliente c);

	public void atualizar(Cliente c);

	public void excluir(Cliente c);

	public Cliente buscar(int id);

	public Cliente buscarPorExemplo(Cliente c);

	public List<Cliente> listar();
}
