package br.com.alura.forum.controller.form;

import br.com.alura.forum.controller.repository.CursoRepository;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicoForm {
    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public Topico converter(CursoRepository repository) {
        Optional<Curso> optionalCurso = repository.findByNome(nomeCurso);

        return optionalCurso.map(curso -> new Topico(titulo, mensagem, curso))
                .orElse(null);
    }
}
