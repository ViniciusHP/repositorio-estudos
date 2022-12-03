package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.abstractions.CrudServiceAbstract;
import br.com.alura.spring.data.service.abstractions.OpcoesInterface;
import br.com.alura.spring.data.util.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCargoService extends CrudServiceAbstract {

    @Autowired
    private CargoRepository cargoRepository;

    private boolean system = true;

    public CrudCargoService() {
        super("Qual ação de Cargo deseja executar?");
    }

    @Override
    protected void salvar(ScannerWrapper scanner) {
        System.out.println("Descrição do cargo: ");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }

    @Override
    protected void atualizar(ScannerWrapper scanner) {
        System.out.println("Id do cargo: ");
        int id = scanner.nextInt();

        Optional<Cargo> cargoOptional = cargoRepository.findById(id);

        if(cargoOptional.isEmpty()) {
            System.out.println("Cargo de id " + id + " não foi encontrado!");
            return;
        }

        Cargo cargo = cargoOptional.get();

        System.out.println("Descrição do cargo: ");
        String descricao = scanner.next();

        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Cargo editado com sucesso!");
    }

    @Override
    protected void visualizar() {
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(System.out::println);
    }

    @Override
    protected void deletar(ScannerWrapper scanner) {
        System.out.println("Id do cargo: ");
        int id = scanner.nextInt();
        cargoRepository.deleteById(id);
        System.out.println("Cargo de id " + id + " foi deletado.");
    }
}
