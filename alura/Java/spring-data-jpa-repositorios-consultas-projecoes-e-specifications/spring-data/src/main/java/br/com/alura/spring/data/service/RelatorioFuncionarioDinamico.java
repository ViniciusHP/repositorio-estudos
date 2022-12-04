package br.com.alura.spring.data.service;

import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.service.abstractions.OpcoesInterface;
import br.com.alura.spring.data.specification.SpecificationFuncionario;
import br.com.alura.spring.data.util.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RelatorioFuncionarioDinamico implements OpcoesInterface {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public void opcoes(ScannerWrapper scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
    }
}
