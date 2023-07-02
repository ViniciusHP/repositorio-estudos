package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CalculadoraDeDescontosTest {

    private CalculadoraDeDescontos calculadoraDeDescontos;

    @Before
    public void beforeEach() {
        calculadoraDeDescontos = new CalculadoraDeDescontos();
    }

    @Test
    public void shouldReturn10PercentOfTheValueWhenCalledWithMoreThan5Items() {
        Orcamento orcamento = new Orcamento(new BigDecimal("200"), 6);
        assertEquals(new BigDecimal("20.0"), calculadoraDeDescontos.calcular(orcamento));
    }

    @Test
    public void shouldReturn10PercentOfTheValueWhenCalledWithValueMoreThan500() {
        Orcamento orcamento = new Orcamento(new BigDecimal("1000"), 1);
        assertEquals(new BigDecimal("100.0"), calculadoraDeDescontos.calcular(orcamento));
    }

    @Test
    public void shouldReturnZeroWhenCalledWithLessThan5Items() {
        Orcamento orcamento = new Orcamento(new BigDecimal("200"), 4);
        assertEquals(BigDecimal.ZERO, calculadoraDeDescontos.calcular(orcamento));
    }
}
