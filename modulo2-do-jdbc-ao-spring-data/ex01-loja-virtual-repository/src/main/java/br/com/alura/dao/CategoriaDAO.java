package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.modelo.Categoria;

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

}
