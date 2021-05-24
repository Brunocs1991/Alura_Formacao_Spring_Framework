package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(Banco.chaveSequencial++);
		empresa1.setNome("Alura");
		lista.add(empresa1);
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("bruno");
		u1.setSenha("123");
		listaUsuarios.add(u1);
		Usuario u2 = new Usuario();
		u2.setLogin("teste");
		u2.setSenha("teste");
		listaUsuarios.add(u2);		

	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresa() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() ==id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public Usuario existeUsuario(String login, String senha) {
	    for(Usuario usuario : listaUsuarios) {
	        if(usuario.ehIgual(login, senha)) { 
	            return usuario;
	        }
	    }
	    return null;
	}
}
