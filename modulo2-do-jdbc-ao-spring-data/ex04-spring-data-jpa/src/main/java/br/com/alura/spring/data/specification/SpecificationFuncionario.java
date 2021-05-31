package br.com.alura.spring.data.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;

public class SpecificationFuncionario {
	
	public static Specification<Funcionario> nome(String nome){
		return (root, criteriaQuery, criteriaBuilder) -> 
		criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
}
