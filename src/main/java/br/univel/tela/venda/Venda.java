package br.univel.tela.venda;

import java.util.Date;
import java.util.List;
import br.univel.cliente.Cliente;
import br.univel.produto.Produto;

public class Venda {
	private Cliente cliente;
	private List<Produto> produto;;
	private Date data;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
