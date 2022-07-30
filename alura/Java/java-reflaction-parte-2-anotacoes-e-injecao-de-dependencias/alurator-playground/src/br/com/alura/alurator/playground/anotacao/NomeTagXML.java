package br.com.alura.alurator.playground.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD })
public @interface NomeTagXML {
    public String value(); // Por convenção, toda anotação que tem apenas um atributo, precisa que o atributo recebe o atributo 'value'
}
