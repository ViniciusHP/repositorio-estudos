package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.academico.dominio.aluno.validacoes.LimiteDeTelefonesAtingido;
import br.com.alura.escola.shared.dominio.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach()
    void beforeEach() {
        aluno = new Aluno(new CPF("123.456.789-00"),
                "Fulano da Silva",
                new Email("fulano@email.com"));
    }

    @Test
    void deveriaPermitirAdicionar1Telefone() {
        this.aluno.adicionarTelefone("11", "99999999");
        assertEquals(1, this.aluno.getTelefones().size());
    }

    @Test
    void deveriaPermitirAdicionar2Telefones() {
        this.aluno.adicionarTelefone("11", "99999999");
        this.aluno.adicionarTelefone("11", "88888888");
        assertEquals(2, this.aluno.getTelefones().size());
    }

    @Test
    void naoDeveriaPermitirAdicionar3Telefones() {
        assertThrows(LimiteDeTelefonesAtingido.class, () -> {
            this.aluno.adicionarTelefone("11", "99999999");
            this.aluno.adicionarTelefone("11", "88888888");
            this.aluno.adicionarTelefone("11", "77777777");
        });
    }
}
