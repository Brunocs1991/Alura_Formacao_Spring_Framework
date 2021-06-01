package br.com.alura.mvc.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;

@Repository
public class PedidoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Pedido> recuperaTodosOsPedidos() {
		Query query = entityManager.createQuery("SELECT p from Pedido p");
		return query.getResultList();
	}
}
