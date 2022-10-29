package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

public class ContainerIoC {

    private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();

    public Object getInstancia(Class<?> tipoFonte) {
        Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);

        if(tipoDestino != null) {
            return getInstancia(tipoDestino);
        }

        Stream<Constructor<?>> construtores =
                Stream.of(tipoFonte.getDeclaredConstructors());

        Optional<Constructor<?>> construtorPadrao =
                construtores
                    .filter((construtor) -> construtor.getParameterCount() == 0)
                    .findFirst();

        try {
            if(construtorPadrao.isPresent()) {
                return construtorPadrao.get().newInstance();
            }

            Constructor<?> construtor = tipoFonte.getDeclaredConstructors()[0];

            List<Object> params = new ArrayList<>();
            for(Parameter param: construtor.getParameters()) {
                Class<?> tipoDoParametro = param.getType();
                params.add(getInstancia(tipoDoParametro));
            }

            return construtor.newInstance(params.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {


        /* Comentado, pois foi tratado pelo generics, fazendo com que caso seja informado tipos incompatíveis, em tempo de desenvolvimento nós sejamos informados */
//        boolean compativel = verificaCompatibilidade(tipoFonte, tipoDestino);
//        if(!compativel) throw  new ClassCastException("Não é possível resolver " + tipoFonte.getName() + " para " + tipoDestino.getName());
        mapaDeTipos.put(tipoFonte, tipoDestino);
    }

//    private boolean verificaCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) {
        // verifica se tipoDestino é compatível com tipoDestino na raça
//        boolean compativel;
//
//        if(tipoFonte.isInterface()) {
//            compativel = Stream.of(tipoDestino.getInterfaces())
//                    .anyMatch((interfaceImplementada) -> interfaceImplementada.equals(tipoFonte));
//        } else {
//            compativel = tipoDestino.getSuperclass().equals(tipoFonte)
//                            || tipoDestino.equals(tipoFonte);
//        }
//
//        return compativel;

        // verificar compatibilidade com API de Reflection
        // neste método será tentado converter para o tipo informado, se der certo, retorna true, senão, false
//        return tipoFonte.isAssignableFrom(tipoDestino);
//    }
}
