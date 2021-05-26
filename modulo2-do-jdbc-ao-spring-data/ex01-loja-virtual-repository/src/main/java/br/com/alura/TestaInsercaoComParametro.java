package br.com.alura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		String nome = "Mouse";
		String descricao = "Mouse em fio";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into produto (nome, descricao) values (?, ?)",
				Statement.RETURN_GENERATED_KEYS
				);

		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao);

		preparedStatement.execute();

		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println("O id gerado foi: " + id);
		}
		connection.close();
	}
}
