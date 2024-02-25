package generation.postagem.controller;

import generation.postagem.domain.model.Postagem;
import generation.postagem.service.impl.PostagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/postagem")
public class PostagemController {
    private final PostagemService postagemService;

    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Postagem>> findAll() {
        return ResponseEntity.ok(postagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> findById(@PathVariable Long id) {
        var obj = postagemService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Postagem> create(@RequestBody Postagem request) {
        var obj = postagemService.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(location).body(obj);
    }

    @PutMapping
    public ResponseEntity<Postagem> update(@RequestBody Postagem request) {
        return ResponseEntity.ok(postagemService.update(request));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        boolean deletou = postagemService.delete(id);
        if (deletou){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
