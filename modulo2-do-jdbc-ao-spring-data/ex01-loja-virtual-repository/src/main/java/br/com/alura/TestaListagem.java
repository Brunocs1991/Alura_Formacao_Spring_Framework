package br.com.alura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection(

				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
				"root",
				"root"
				);
		
		Statement statement = connection.createStatement();
		statement.execute("select id, nome, descricao from produto");
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			
			System.out.println(id +  nome + descricao);
		}
		connection.close();

	}

}
