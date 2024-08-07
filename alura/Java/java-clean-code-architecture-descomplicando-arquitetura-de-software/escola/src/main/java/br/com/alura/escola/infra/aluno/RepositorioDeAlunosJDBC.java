package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            for (Telefone telefone : aluno.getTelefones()) {
                ps = connection.prepareStatement(sql);
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet rs = ps.executeQuery();

            boolean encontrou = rs.next();
            if(!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");
            adicionarTelefones(id, encontrado);
            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try {
            String sql = "SELECT id, cpf, nome, email FROM ALUNO";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();

            while(rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = rs.getLong("id");
                adicionarTelefones(id, aluno);
                alunos.add(aluno);
            }

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void adicionarTelefones(Long idAluno, Aluno aluno) {
        try {
            String sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, idAluno);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                aluno.adicionarTelefone(ddd, numero);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
