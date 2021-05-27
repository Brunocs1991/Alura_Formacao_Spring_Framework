package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			connection.setAutoCommit(false);

			try (PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into produto (nome, descricao) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				adicionarVariavel("SmartTv", "45 polegadas", preparedStatement);
				adicionarVariavel("Radio", "Radio de bateria", preparedStatement);
				connection.commit();
			} catch (Exception e) {

				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement preparedStatement)
			throws SQLException {

		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao);

		/*
		 * if(nome.equals("Radio")) { throw new
		 * RuntimeException("Não foi possivel adicionar o produto"); }
		 */

		preparedStatement.execute();

		try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				System.out.println("O id gerado foi: " + id);
			}
		}
	}
}
