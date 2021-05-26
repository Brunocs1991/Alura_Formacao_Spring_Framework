package br.com.alura;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement statement = connection.createStatement();
		statement.execute("delete from produto where id > 2");
		Integer linhasModificadas =  statement.getUpdateCount();
		System.out.println("Quantidade de linhas afetadas: " + linhasModificadas);
		connection.close();
	}
}
