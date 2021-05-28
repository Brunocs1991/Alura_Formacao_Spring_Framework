package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

public class TestaListagemCategorias {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategoria = categoriaDAO.listarComProdutos();

			listaDeCategoria.stream().forEach(ct -> {
				System.out.println(ct.getNome());

				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}
}
