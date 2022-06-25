package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjetoCorretamente {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<SubControle> subControleClasse1 = SubControle.class;

        Class<?> subControleClasse2 =
                Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Class<?> controleClasse1 =
                Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Constructor<SubControle> construtorSubControle = subControleClasse1.getDeclaredConstructor();
        construtorSubControle.setAccessible(true);
        Object subControle = construtorSubControle.newInstance();
        System.out.println(subControle);
    }
}
