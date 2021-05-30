package br.com.alura.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.spring.data.orm.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
	List<Funcionario> findByNome(String nome);	
}
