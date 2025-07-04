package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.service.abstractions.OpcoesInterface;
import br.com.alura.spring.data.util.LocalDateUtils;
import br.com.alura.spring.data.util.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioService implements OpcoesInterface {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    private Boolean system = true;


    @Override
    public void opcoes(ScannerWrapper scanner) {
        while(system) {
            System.out.println("Qual relatório deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionário por nome");
            System.out.println("2 - Buscar funcionário por nome, data de contratação e salário maior");
            System.out.println("3 - Buscar funcionário por data de contratação");
            System.out.println("4 - Buscar projeção funcionários");
            int action = scanner.nextInt();

            switch (action) {
                case 1 -> buscaFuncionarioPorNome(scanner);
                case 2 -> buscaNomeSalarioMaiorDataContratacao(scanner);
                case 3 -> buscaFuncionarioDataContratacao(scanner);
                case 4 -> buscaFuncionarioSalario();
                default -> system = false;
            }
        }
    }

    private void buscaFuncionarioPorNome(ScannerWrapper scanner) {
        System.out.println("Qual o nome deseja pesquisar: ");
        String nome = scanner.nextLine();
        List<Funcionario> listaFuncionarios = funcionarioRepository.findByNomeLike(nome);
        listaFuncionarios.forEach(System.out::println);
    }

    private void buscaNomeSalarioMaiorDataContratacao(ScannerWrapper scanner){

        System.out.println("Qual nome deseja pesquisar: ");
        String nome = scanner.nextLine();

        System.out.println("Qual salário maior deseja pesquisar: ");
        BigDecimal salario = scanner.nextBigDecimal();

        System.out.println("Qual data de contratação deseja pesquisar: ");
        String data = scanner.nextLine();
        LocalDate dataContratacao = LocalDateUtils.parse(data);

        List<Funcionario> funcinarios = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, dataContratacao);
        funcinarios.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacao(ScannerWrapper scanner) {
        System.out.println("Qual data de contratação deseja pesquisar: ");
        String data = scanner.nextLine();
        LocalDate dataContratacao = LocalDateUtils.parse(data);
        List<Funcionario> funcionarios = funcionarioRepository.findDataContratacaoMaior(dataContratacao);
        funcionarios.forEach(System.out::println);
    }

    private void buscaFuncionarioSalario() {
        List<FuncionarioProjecao> funcionarios = funcionarioRepository.findFuncionarioSalario();
        funcionarios.forEach((f) -> System.out.printf("Funcionário: id: %d, nome: %s, salario: %s%n", f.getId(), f.getNome(), f.getSalario()));
    }
}
