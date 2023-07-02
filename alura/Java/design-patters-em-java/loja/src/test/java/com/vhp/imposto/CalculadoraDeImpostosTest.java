package com.vhp.imposto;

import com.vhp.orcamento.Orcamento;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.math.BigDecimal;

public class CalculadoraDeImpostosTest {

    CalculadoraDeImpostos calculadoraDeImpostos;

    @Before()
    public void beforeEach() {
        calculadoraDeImpostos = new CalculadoraDeImpostos();
    }

    @Test
    public void shouldIcmsReturn10Percent() {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        Assert.assertEquals(new BigDecimal("10.0"), calculadoraDeImpostos.calcular(orcamento, new ICMS()));
    }

    @Test
    public void shouldIssReturn6Percent() {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        Assert.assertEquals(new BigDecimal("6.00"), calculadoraDeImpostos.calcular(orcamento, new ISS()));
    }
}
