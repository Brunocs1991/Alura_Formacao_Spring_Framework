package br.com.alura.gerenciador.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.model.Empresa;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.lista;
	}

}
