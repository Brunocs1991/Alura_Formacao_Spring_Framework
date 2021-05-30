package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;

@SpringBootApplication
public class Ex04SpringDataJpaApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private Boolean system = true; 

	public Ex04SpringDataJpaApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Ex04SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação voce quer executar? ");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			
			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.inicial(scanner);
			}if(action == 0) {
				system = false;
			}else {
				System.out.println("Opção invalida");
			}
		}
		
	}

}
