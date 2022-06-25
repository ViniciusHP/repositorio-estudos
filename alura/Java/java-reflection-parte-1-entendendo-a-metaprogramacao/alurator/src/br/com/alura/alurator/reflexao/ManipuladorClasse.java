package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {
    private final Class<?> classe;

    public ManipuladorClasse(Class<?> classe) {
        this.classe = classe;
    }

    public ManipuladorConstrutor getContrutorPadrao() {
        try {
            Constructor<?> construtorPadrao = this.classe.getDeclaredConstructor();
            return new ManipuladorConstrutor(construtorPadrao);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public ManipuladorObjeto criaInstancia() {
        Object instancia = getContrutorPadrao().invoca();
        return new ManipuladorObjeto(instancia);
    }
}
