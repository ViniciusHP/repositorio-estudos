package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDTO;
import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;
    
    @GetMapping()
    @Cacheable(value = "listaDeTopicos")
    public Page<TopicoDTO> lista(@RequestParam(required = false) String nomeCurso,
                                 @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        /* Para funcionar a passagem do pageable, é necessário da anotação @EnableSpringDataWebSupport */
        Page<Topico> topicos = nomeCurso == null
                ? topicoRepository.findAll(paginacao)
                : topicoRepository.findByCurso_Nome(nomeCurso, paginacao);
        return TopicoDTO.converter(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        return optionalTopico
                .map(topico -> ResponseEntity.ok(new DetalhesDoTopicoDTO(topico)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @Operation(summary = "Cadastrar tópico", description = "Cadastrar tópico")
    @PostMapping()
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topico = topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @Operation(summary = "Alterar tópico", description = "Alterar tópico")
    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        TopicoDTO topico = form.atualizar(id, topicoRepository);

        return topico == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(topico);
    }

    @Operation(summary = "Excluir tópico", description = "Excluir tópico")
    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        return optionalTopico.map((topico) -> {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
