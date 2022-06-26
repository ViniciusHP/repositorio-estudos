package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> classeControle =
                Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Constructor<?> construtorPadrao = classeControle.getDeclaredConstructor();

        Object instanciaControle = construtorPadrao.newInstance();

        Method method = classeControle.getDeclaredMethod("metodoControle2", String.class, Integer.class);

        Object retorno = method.invoke(instanciaControle, "Pintassilgo do Agreste", 1);
        System.out.println(retorno);
    }
}
