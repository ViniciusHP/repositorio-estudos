package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class BonusServiceTest {

    @Test
    public void lancaExcecaoParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Vinicius", LocalDate.now(), BigDecimal.valueOf(25000));

//        try{
//            service.calcularBonus(funcionario);
//            fail("Não deu a exception!");
//        }catch (IllegalArgumentException e) {
//            assertEquals("Funcionário com salário maior do que R$ 10.000,00 não pode receber bônus.", e.getMessage());
//        }

        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal salario = BigDecimal.valueOf(2500);
        BigDecimal bonus = service.calcularBonus(new Funcionario("Vinicius", LocalDate.now(), salario));

        assertEquals(salario.multiply(BigDecimal.valueOf(0.1)), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal salario = BigDecimal.valueOf(1000);
        BigDecimal bonus = service.calcularBonus(new Funcionario("Vinicius", LocalDate.now(), salario));

        assertEquals(salario.multiply(BigDecimal.valueOf(0.1)), bonus);
    }
}
