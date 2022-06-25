package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;

public class ManipuladorObjeto {
    private final Object instancia;

    public ManipuladorObjeto(Object instancia) {
        this.instancia = instancia;
    }

    public ManipuladorMetodo getMetodo(String nomeMetodo) {
        try {
            Method metodo = instancia.getClass().getDeclaredMethod(nomeMetodo);
            return new ManipuladorMetodo(instancia, metodo);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
