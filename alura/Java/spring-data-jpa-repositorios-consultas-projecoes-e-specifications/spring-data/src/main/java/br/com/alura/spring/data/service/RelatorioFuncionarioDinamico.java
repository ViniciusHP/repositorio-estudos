package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.service.abstractions.OpcoesInterface;
import br.com.alura.spring.data.specification.SpecificationFuncionario;
import br.com.alura.spring.data.util.LocalDateUtils;
import br.com.alura.spring.data.util.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioFuncionarioDinamico implements OpcoesInterface {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public void opcoes(ScannerWrapper scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        if("NULL".equalsIgnoreCase(nome)){
            nome = null;
        }

        System.out.println("Digite o cpf:");
        String cpf = scanner.nextLine();

        if("NULL".equalsIgnoreCase(cpf)){
            cpf = null;
        }

        System.out.println("Digite o salário:");
        BigDecimal salario = scanner.nextBigDecimal();

        if(BigDecimal.ZERO.equals(salario)){
            salario = null;
        }

        System.out.println("Digite a data contratação:");
        String data = scanner.nextLine();

        LocalDate dataContratacao = null;
        if(!"NULL".equalsIgnoreCase(data)) {
            dataContratacao = LocalDateUtils.parse(data);
        }

        List<Funcionario> funcionarios = funcionarioRepository.findAll(
                Specification.where(
                        SpecificationFuncionario.nome(nome)
                                .or(SpecificationFuncionario.cpf(cpf))
                                .or(SpecificationFuncionario.salario(salario))
                                .or(SpecificationFuncionario.dataContratacao(dataContratacao))
                )
        );

        funcionarios.forEach(System.out::println);
    }
}
