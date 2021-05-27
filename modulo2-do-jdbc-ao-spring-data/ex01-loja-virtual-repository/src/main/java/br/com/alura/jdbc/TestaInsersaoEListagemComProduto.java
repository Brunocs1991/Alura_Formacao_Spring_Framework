package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.dao.ProdutoDAO;
import br.com.alura.modelo.Produto;

public class TestaInsersaoEListagemComProduto {
	
	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection  = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(produto);
			
			List<Produto> listaDeProdutos= produtoDAO.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}
