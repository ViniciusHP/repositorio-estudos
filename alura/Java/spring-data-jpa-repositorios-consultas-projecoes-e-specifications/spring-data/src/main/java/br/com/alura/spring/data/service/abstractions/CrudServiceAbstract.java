package br.com.alura.spring.data.service.abstractions;

import br.com.alura.spring.data.util.ScannerWrapper;

public abstract class CrudServiceAbstract implements OpcoesInterface {

    private boolean system = true;

    private final String mensagemInicialMenu;

    public CrudServiceAbstract(String mensagemInicialMenu) {
        this.mensagemInicialMenu = mensagemInicialMenu;
    }

    public void opcoes(ScannerWrapper scanner) {
        system = true;
        while(system) {
            System.out.println(this.mensagemInicialMenu);
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
                    visualizar(scanner);
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

    protected abstract void visualizar(ScannerWrapper scanner);

    protected abstract void deletar(ScannerWrapper scanner);
}
