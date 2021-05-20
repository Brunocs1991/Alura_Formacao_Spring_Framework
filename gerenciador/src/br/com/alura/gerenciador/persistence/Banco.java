package br.com.alura.gerenciador.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.model.Empresa;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Alura");
		lista.add(empresa1);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		lista.add(empresa2);
		
	}

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.lista;
	}

}
