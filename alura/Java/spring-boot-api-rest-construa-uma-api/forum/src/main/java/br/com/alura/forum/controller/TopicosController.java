package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.controller.repository.CursoRepository;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public List<TopicoDto> lista(String nomeCurso) {
        List<Topico> topicos = nomeCurso == null
                ? topicoRepository.findAll()
                : topicoRepository.findByCurso_Nome(nomeCurso);
        return TopicoDto.converter(topicos);
    }


    @PostMapping()
    public void cadastrar(@RequestBody TopicoForm form) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);
    }
}
