package br.com.alura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.modelo.Produto;

public class TestaInsersaoComProduto {
	
	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection  = new ConnectionFactory().recuperarConexao()){
			String sql = "insert into produto (nome, descricao) values(?, ?)";
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				preparedStatement.setString(1, produto.getNome());
				preparedStatement.setString(2, produto.getDescricao());
				
				preparedStatement.execute();
				
				try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
					while(resultSet.next()) {
						produto.setId(resultSet.getInt(1));
					}
				}
			}
		}
		System.out.println(produto);
	}
}
