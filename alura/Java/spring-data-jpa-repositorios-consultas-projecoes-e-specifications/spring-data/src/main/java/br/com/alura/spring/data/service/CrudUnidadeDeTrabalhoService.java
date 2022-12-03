package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.UnidadeDeTrabalhoRepository;
import br.com.alura.spring.data.service.abstractions.CrudServiceAbstract;
import br.com.alura.spring.data.util.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrudUnidadeDeTrabalhoService extends CrudServiceAbstract {

    @Autowired
    private UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository;

    public CrudUnidadeDeTrabalhoService() {
        super("Qual ação de Unidade de Trabalho deseja executar?");
    }

    @Override
    protected void salvar(ScannerWrapper scanner) {
        System.out.println("Informe a descrição da unidade de trabalho: ");
        String descricao = scanner.nextLine();

        System.out.println("Informe o endereço da unidade de trabalho: ");
        String endereco = scanner.nextLine();

        UnidadeDeTrabalho udt = new UnidadeDeTrabalho();
        udt.setDescricao(descricao);
        udt.setEndereco(endereco);

        unidadeDeTrabalhoRepository.save(udt);
        System.out.println("Unidade de trabalho cadastrada com sucesso!");
    }

    @Override
    protected void atualizar(ScannerWrapper scanner) {
        System.out.println("Informe o ID unidade de trabalho: ");
        long id = scanner.nextLong();

        Optional<UnidadeDeTrabalho> udtOptional = unidadeDeTrabalhoRepository.findById(id);

        if(udtOptional.isEmpty()) {
            System.out.println("Unidade de trabalho não encontrada!");
            return;
        }

        UnidadeDeTrabalho udt = udtOptional.get();

        System.out.println("Informe a descrição da unidade de trabalho: ");
        String descricao = scanner.nextLine();

        System.out.println("Informe o endereço da unidade de trabalho: ");
        String endereco = scanner.nextLine();

        udt.setDescricao(descricao);
        udt.setEndereco(endereco);

        unidadeDeTrabalhoRepository.save(udt);

        System.out.println("Unidade de trabalho atualizada com sucesso!");
    }

    @Override
    protected void visualizar(ScannerWrapper scanner) {
        Iterable<UnidadeDeTrabalho> unidadesDeTrabalho = unidadeDeTrabalhoRepository.findAll();
        unidadesDeTrabalho.forEach(System.out::println);
    }

    @Override
    protected void deletar(ScannerWrapper scanner) {
        System.out.println("Informe o ID unidade de trabalho: ");
        long id = scanner.nextLong();
        unidadeDeTrabalhoRepository.deleteById(id);
        System.out.println("Unidade de trabalho deletada com sucesso!");
    }
}
