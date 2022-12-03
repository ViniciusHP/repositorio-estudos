package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeDeTrabalhoService;
import br.com.alura.spring.data.util.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private boolean system = true;

	private CrudCargoService cargoService;

	private CrudUnidadeDeTrabalhoService unidadeDeTrabalhoService;

	private CrudFuncionarioService funcionarioService;

	@Autowired
	public SpringDataApplication(CrudCargoService cargoService, CrudUnidadeDeTrabalhoService unidadeDeTrabalhoService, CrudFuncionarioService funcionarioService) {
		this.cargoService = cargoService;
		this.unidadeDeTrabalhoService = unidadeDeTrabalhoService;
		this.funcionarioService = funcionarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ScannerWrapper scanner = new ScannerWrapper(new Scanner(System.in));

		while (system) {
			System.out.println("Qual ação você deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Unidade de trabalho");
			System.out.println("3 - Funcionário");

			int action = scanner.nextInt();

			switch (action) {
				case 1 -> cargoService.inicial(scanner);
				case 2 -> unidadeDeTrabalhoService.inicial(scanner);
				case 3 -> funcionarioService.inicial(scanner);
				default -> system = false;
			}
		}
		scanner.close();
	}
}
