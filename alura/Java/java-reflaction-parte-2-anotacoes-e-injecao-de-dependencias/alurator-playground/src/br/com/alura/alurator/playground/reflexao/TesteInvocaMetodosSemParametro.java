package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodosSemParametro {
    public static void main(String[] args) throws Exception{
        Class<?> subControleClasse =
                Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
        construtorPadrao.setAccessible(true);
        Object instanciaSubControle = construtorPadrao.newInstance();

        for(Method m : subControleClasse.getMethods()) {
            System.out.println(m);
        }

        System.out.println();

        for(Method m : subControleClasse.getDeclaredMethods()) {
            System.out.println(m);
        }

        System.out.println();

        Method m = subControleClasse.getDeclaredMethod("metodoSubControle2");
        m.setAccessible(true);
        Object retorno = m.invoke(instanciaSubControle);

        System.out.println(retorno);
    }
}
