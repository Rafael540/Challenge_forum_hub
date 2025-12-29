package controller;

import domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicosRepository repository;

    public ResponseEntity<Topico> cadastrar(
            @RequestBody @Valid DadosCadastroTopico dados,
            UriComponentsBuilder uriBuilder
            ) {
        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(topico);

    }

    @GetMapping
    public ResponseEntity<Page<TopicosListados>> listar(
            @PageableDefault(
                    size = 10,
                    sort = "dataCriacao",
                    direction = Sort.Direction.ASC
            ) Pageable paginacao
    ) {
        var page = repository.findAll(paginacao).map(TopicosListados::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoTopico> detalhar(@PathVariable Long id){
        var topico = repository.findById(id);

        if(topico.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetalhamentoTopico(topico.get()));
    }

    @PutMapping("/topicos/{id}")
    @Transactional
    public ResponseEntity<DetalhamentoTopico> atualizar(@PathVariable Long id,
                                                        @RequestBody @Valid AtualizacaoTopico dados){

        var optionalTopico = repository.findById(id);

        if(optionalTopico.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var topico = optionalTopico.get();
        topico.atualizar(dados);

        return ResponseEntity.ok(new DetalhamentoTopico(topico));
    }


    @DeleteMapping("/topicos/{id}")
    @Transactional
    public ResponseEntity<Topico> deletar(@PathVariable Long id,
                                          @RequestBody @Valid TopicosListados dados){
        var topico = repository.findById(id);

        if(topico.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
        }

}
