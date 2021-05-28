package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "select id, nome from categoria";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.execute();
			try (ResultSet resultSet = preparedStatement.getResultSet()) {
				while (resultSet.next()) {
					Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Categoria> listarComProdutos() throws SQLException {

		Categoria ultima = null;
		List<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "select c.id, c.nome, p.id, p.nome, p.descricao " + "from categoria c " + "inner join produto p "
				+ "on c.id = p.categoria_id";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.execute();
			try (ResultSet resultSet = preparedStatement.getResultSet()) {
				while (resultSet.next()) {
					if (ultima == null || !ultima.getNome().equals(resultSet.getString(2))) {
						Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
						ultima = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
					ultima.adicionar(produto);
				}
			}
		}
		return categorias;
	}

}
