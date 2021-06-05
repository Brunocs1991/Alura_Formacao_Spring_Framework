package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.alura.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long pedidoId;
	private String valor;
	private String dataDaEntrega;
	private String commentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getCommentario() {
		return commentario;
	}

	public void setCommentario(String commentario) {
		this.commentario = commentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setCommentario(this.commentario);
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega,formatter));
		oferta.setValor(new BigDecimal(this.valor));
		
		return oferta;
	}

}
