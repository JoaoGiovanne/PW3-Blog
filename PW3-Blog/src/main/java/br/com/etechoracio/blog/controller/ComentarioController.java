// Giovanne Pagano dos Santos, 3ºAI


package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.entity.Comentario;
import br.com.etechoracio.blog.entity.Post;
import br.com.etechoracio.blog.repository.ComentarioRepository;
import br.com.etechoracio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioRepository repository;

    @GetMapping
    public List<Comentario> listarComentarios() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscarPorId(@PathVariable Long id){
        var resposta = repository.findById(id);
        if (resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(resposta.get());
        }
    }

    @PostMapping
    public ResponseEntity<Comentario> inserir(@RequestBody Comentario comentario){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> atualizar(@PathVariable Long id, @RequestBody Comentario comentario){
        var existe = repository.findById(id);
        if(existe.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            comentario.setId(id);
            Comentario updateComentario = repository.save(comentario);
            return ResponseEntity.ok(updateComentario);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comentario> deletar(@PathVariable Long id){
        var existe = repository.findById(id);
        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
