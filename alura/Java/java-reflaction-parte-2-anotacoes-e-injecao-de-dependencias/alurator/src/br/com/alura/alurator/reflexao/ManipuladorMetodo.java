package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManipuladorMetodo {
    private Object instancia;
    private Method metodo;
    private Map<String, Object> params;

    private BiFunction<Method, InvocationTargetException, Object> funcaoTratamento;

    public ManipuladorMetodo(Object instancia, Method metodo, Map<String, Object> params) {
        this.instancia = instancia;
        this.metodo = metodo;
        this.params = params;
    }


    public Object invoca() {
        try {
            List<Object> parametros = Stream.of(metodo.getParameters())
                    .map(p -> params.get(p.getName()))
                    .toList();
            return metodo.invoke(instancia, parametros.toArray());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            if(funcaoTratamento != null) {
                return funcaoTratamento.apply(metodo, e);
            }

            e.printStackTrace();
            throw new RuntimeException("Erro dentro do método", e);
        }
    }

    public ManipuladorMetodo comTratamentoDeExcecao(BiFunction<Method, InvocationTargetException, Object> funcaoTratamento) {
        this.funcaoTratamento = funcaoTratamento;
        return this;
    }
}
