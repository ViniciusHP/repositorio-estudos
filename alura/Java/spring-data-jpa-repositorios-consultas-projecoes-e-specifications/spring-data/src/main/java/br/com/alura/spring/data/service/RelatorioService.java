package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.service.abstractions.OpcoesInterface;
import br.com.alura.spring.data.util.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService implements OpcoesInterface {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    private Boolean system = true;


    @Override
    public void opcoes(ScannerWrapper scanner) {
        while(true) {

            System.out.println("Qual relatório deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionário por nome");
            int action = scanner.nextInt();

            switch (action) {
                case 1 -> buscaFuncionarioPorNome(scanner);
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
}
