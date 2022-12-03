package br.com.alura.spring.data.service;

import br.com.alura.spring.data.util.ScannerWrapper;

import java.util.Scanner;

public abstract class CrudServiceAbstract {

    private boolean system = true;

    public void inicial(ScannerWrapper scanner) {
        system = true;
        while(system) {
            System.out.println("Qual ação de cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;

                case 2:
                    atualizar(scanner);
                    break;

                case 3:
                    visualizar();
                    break;

                case 4:
                    deletar(scanner);
                    break;

                default:
                    system = false;
                    break;
            }
        }
    }

    protected abstract void salvar(ScannerWrapper scanner);

    protected abstract void atualizar(ScannerWrapper scanner);

    protected abstract void visualizar();

    protected abstract void deletar(ScannerWrapper scanner);
}
