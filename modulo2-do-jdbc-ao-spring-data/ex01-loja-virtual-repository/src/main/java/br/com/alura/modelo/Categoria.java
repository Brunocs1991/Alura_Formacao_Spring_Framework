package br.com.alura.modelo;

public class Categoria {

	private Integer id;
	private String nome;

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}

}
