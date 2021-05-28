package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data = LocalDate.now();
	private BigDecimal valorTotal;

	@ManyToOne
	private Cliente cliente;

	public Pedido() {
		super();
	}

	public Pedido(Cliente cliente_id) {
		super();
		this.cliente = cliente_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente_id() {
		return cliente;
	}

	public void setCliente_id(Cliente cliente_id) {
		this.cliente = cliente_id;
	}

	public BigDecimal getValor_total() {
		return valorTotal;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valorTotal = valor_total;
	}

}
