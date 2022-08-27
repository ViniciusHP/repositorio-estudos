package br.com.alura.forum.controller.form;

import br.com.alura.forum.controller.repository.CursoRepository;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicoForm {

    @NotNull @NotEmpty @Size(min = 5)
    private String titulo;

    @NotNull @NotEmpty @Size(min = 10)
    private String mensagem;

    @NotNull @NotEmpty
    private String nomeCurso;

    public Topico converter(CursoRepository repository) {
        Optional<Curso> optionalCurso = repository.findByNome(nomeCurso);

        return optionalCurso.map(curso -> new Topico(titulo, mensagem, curso))
                .orElse(null);
    }
}
