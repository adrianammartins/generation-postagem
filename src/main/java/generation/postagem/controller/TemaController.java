package generation.postagem.controller;

import generation.postagem.domain.model.Tema;
import generation.postagem.service.impl.TemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/tema")
public class TemaController {
    private final TemaService temaService;

    public TemaController(TemaService temaService) {
        this.temaService = temaService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Tema>> findAll() {
        return ResponseEntity.ok(temaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> findById(@PathVariable Long id) {
        var obj = temaService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Tema> create(@RequestBody Tema request) {
        var obj = temaService.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(location).body(obj);
    }

    @PutMapping
    public ResponseEntity<Tema> update(@RequestBody Tema request) {
        return ResponseEntity.ok(temaService.update(request));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        boolean deletou = temaService.delete(id);
        if (deletou){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
