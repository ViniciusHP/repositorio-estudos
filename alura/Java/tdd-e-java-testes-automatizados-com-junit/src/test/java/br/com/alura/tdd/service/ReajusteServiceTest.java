package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    @Test
    public void reajusteDeveriaSerDe3PorcentoQuandoDesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();
        BigDecimal salario = BigDecimal.valueOf(1000);
        Funcionario funcionario = new Funcionario("Vinicius", LocalDate.now(), salario);
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        BigDecimal salarioComReajuste = salario.multiply(BigDecimal.valueOf(0.03))
            .add(salario)
            .setScale(2, RoundingMode.HALF_UP);

        assertEquals(salarioComReajuste, funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe15PorcentoQuandoDesempenhoForBom() {
        ReajusteService service = new ReajusteService();
        BigDecimal salario = BigDecimal.valueOf(1000);
        Funcionario funcionario = new Funcionario("Vinicius", LocalDate.now(), salario);
        service.concederReajuste(funcionario, Desempenho.BOM);
        BigDecimal salarioComReajuste = salario.multiply(BigDecimal.valueOf(0.15))
            .add(salario)
            .setScale(2, RoundingMode.HALF_UP);

        assertEquals(salarioComReajuste, funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe20PorcentoQuandoDesempenhoForOtimo() {
        ReajusteService service = new ReajusteService();
        BigDecimal salario = BigDecimal.valueOf(1000);
        Funcionario funcionario = new Funcionario("Vinicius", LocalDate.now(), salario);
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        BigDecimal salarioComReajuste = salario.multiply(BigDecimal.valueOf(0.20))
            .add(salario)
            .setScale(2, RoundingMode.HALF_UP);

        assertEquals(salarioComReajuste, funcionario.getSalario());
    }
}
