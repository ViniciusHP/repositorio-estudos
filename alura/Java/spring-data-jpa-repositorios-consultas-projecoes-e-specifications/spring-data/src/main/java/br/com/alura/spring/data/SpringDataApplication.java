package br.com.alura.spring.data;

import br.com.alura.spring.data.service.*;
import br.com.alura.spring.data.service.abstractions.OpcoesInterface;
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

	private RelatorioService relatorioService;

	private RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	@Autowired
	public SpringDataApplication(CrudCargoService cargoService, CrudUnidadeDeTrabalhoService unidadeDeTrabalhoService, CrudFuncionarioService funcionarioService, RelatorioService relatorioService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.unidadeDeTrabalhoService = unidadeDeTrabalhoService;
		this.funcionarioService = funcionarioService;
		this.relatorioService = relatorioService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
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
			System.out.println("4 - Relatório");
			System.out.println("5 - Relatório dinâmico");

			int action = scanner.nextInt();



			OpcoesInterface opcaoInterface = null;
			switch (action) {
				case 1 -> opcaoInterface = cargoService;
				case 2 -> opcaoInterface = unidadeDeTrabalhoService;
				case 3 -> opcaoInterface = funcionarioService;
				case 4 -> opcaoInterface = relatorioService;
				case 5 -> opcaoInterface = relatorioFuncionarioDinamico;
				default -> system = false;
			}

			if(opcaoInterface != null) {
				opcaoInterface.opcoes(scanner);
			}
		}
		scanner.close();
	}
}
