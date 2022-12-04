package br.com.alura.spring.data.orm;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public interface FuncionarioProjecao {
    Long getId();
    String getNome();
    BigDecimal getSalario();
}
