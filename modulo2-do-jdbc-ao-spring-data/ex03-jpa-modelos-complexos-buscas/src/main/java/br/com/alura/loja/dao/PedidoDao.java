package br.com.alura.loja.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;

public class PedidoDao {
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "select sum(p.valorTotal) from Pedido p";
		 return this.em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
}
