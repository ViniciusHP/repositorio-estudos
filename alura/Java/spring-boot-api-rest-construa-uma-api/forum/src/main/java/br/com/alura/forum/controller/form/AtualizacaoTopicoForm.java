package br.com.alura.forum.controller.form;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@Getter
@Setter
public class AtualizacaoTopicoForm {

    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String titulo;

    @NotNull @NotEmpty @Size(min = 10)
    private String mensagem;

    public TopicoDTO atualizar(Long id, TopicoRepository topicoRepository) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if(optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.setMensagem(this.mensagem);
            topico.setTitulo(this.titulo);
            return new TopicoDTO(topico);
        }

        return null;
    }
}
