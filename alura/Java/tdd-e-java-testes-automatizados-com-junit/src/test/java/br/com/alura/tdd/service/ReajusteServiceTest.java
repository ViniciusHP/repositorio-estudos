package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private BigDecimal salario;
    private Funcionario funcionario;
    private ReajusteService service;

    @BeforeEach
    public void inicializar() {
        service = new ReajusteService();
        salario = BigDecimal.valueOf(1000);
        funcionario = new Funcionario("Vinicius", LocalDate.now(), salario);
    }

    @AfterEach
    public void finalizar() {
        System.out.println("Finalizado");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("Antes de Todos");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("Depois de Todos");
    }

    @Test
    public void reajusteDeveriaSerDe3PorcentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        BigDecimal salarioComReajuste = salario.multiply(BigDecimal.valueOf(0.03))
            .add(salario)
            .setScale(2, RoundingMode.HALF_UP);

        assertEquals(salarioComReajuste, funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe15PorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        BigDecimal salarioComReajuste = salario.multiply(BigDecimal.valueOf(0.15))
            .add(salario)
            .setScale(2, RoundingMode.HALF_UP);

        assertEquals(salarioComReajuste, funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe20PorcentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        BigDecimal salarioComReajuste = salario.multiply(BigDecimal.valueOf(0.20))
            .add(salario)
            .setScale(2, RoundingMode.HALF_UP);

        assertEquals(salarioComReajuste, funcionario.getSalario());
    }
}
