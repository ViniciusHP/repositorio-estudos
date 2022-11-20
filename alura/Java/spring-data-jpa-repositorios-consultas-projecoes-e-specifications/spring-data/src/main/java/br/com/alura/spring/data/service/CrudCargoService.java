package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;

    private boolean system = true;

    public CrudCargoService(CargoRepository repository) {
        this.cargoRepository = repository;
    }

    public void inicial(Scanner scanner) {
        system = true;
        while(system) {
            System.out.println("Qual ação de cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;

                case 2:
                    atualizar(scanner);
                    break;

                default:
                    system = false;
                    break;
            }
        }
    }

    public void salvar(Scanner scanner) {
        System.out.println("Descrição do cargo: ");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }

    public void atualizar(Scanner scanner) {
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
}
