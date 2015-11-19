package br.univel.usuario;

import java.util.List;

public interface UsuarioDAO {

	public void inserir(Usuario u);

	public void atualizar(Usuario u);

	public void excluir(Usuario u);

	public Usuario buscar(int id);

	public Usuario buscarPorID(Usuario u);

	public List<Usuario> listar();
}
