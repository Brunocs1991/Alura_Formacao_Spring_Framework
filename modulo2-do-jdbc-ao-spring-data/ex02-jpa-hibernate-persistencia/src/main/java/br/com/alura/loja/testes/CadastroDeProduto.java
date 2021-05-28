package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		cadastrarProduto();
		Long id = 1l;
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(id);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(prod -> System.out.println(prod.getNome()));
		
		List<Produto> todosNome = produtoDao.buscarPorNome("Xiaomi Redmi");
		todosNome.forEach(prod -> System.out.println(prod.getNome()));
		
		List<Produto> todosNomeCategoria = produtoDao.buscarPorNomeCategoria("CELULARES");
		todosNomeCategoria.forEach(prod -> System.out.println(prod.getNome()));
		
		BigDecimal precoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
		System.out.println("Preço do produto: " + precoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");		
		Produto celular = new Produto("Xiaomi Redmi", "Muito Legal", new BigDecimal("800"), celulares);
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao	 = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		em.getTransaction().begin();		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);		
		em.getTransaction().commit();
		em.close();
	}
}
