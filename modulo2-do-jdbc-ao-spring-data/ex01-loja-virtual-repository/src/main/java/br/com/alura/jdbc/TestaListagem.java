package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement preparedStatement = connection.prepareStatement("select id, nome, descricao from produto");
		preparedStatement.execute();
		ResultSet resultSet = preparedStatement.getResultSet();
		
		while(resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			
			System.out.println("id: " + id + " | nome: " + nome +  " | descricao: " + descricao);
		}
		connection.close();

	}

}
