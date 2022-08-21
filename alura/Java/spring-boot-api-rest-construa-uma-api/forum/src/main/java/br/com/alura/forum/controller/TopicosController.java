package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDTO;
import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.controller.repository.CursoRepository;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public List<TopicoDTO> lista(String nomeCurso) {
        List<Topico> topicos = nomeCurso == null
                ? topicoRepository.findAll()
                : topicoRepository.findByCurso_Nome(nomeCurso);
        return TopicoDTO.converter(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        return optionalTopico
                .map(topico -> ResponseEntity.ok(new DetalhesDoTopicoDTO(topico)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping()
    @Transactional
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topico = topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        TopicoDTO topico = form.atualizar(id, topicoRepository);

        return topico == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
