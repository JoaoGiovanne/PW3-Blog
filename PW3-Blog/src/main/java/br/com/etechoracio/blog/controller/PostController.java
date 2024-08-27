package br.com.etechoracio.blog.controller;
import br.com.etechoracio.blog.entity.Post;
import br.com.etechoracio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired //cria o objeto quando necessario
    private PostRepository repository; // o repository manipula o dado
    @GetMapping
    public List<Post> listarPosts(){
        return repository.findAll(); //retorna uma lista de posts
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> buscarPorId(@PathVariable Long id){ // é uma variavel que vai vir do path, seria a lista de id
        var resposta = repository.findById(id);
        if (resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(resposta.get());
        }
    }
    @PostMapping
    public ResponseEntity<Post> inserir(@RequestBody Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));// 201 = criado; 200 = deu certo
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> atualizar(@PathVariable Long id, @RequestBody Post post){
        var existe = repository.findById(id);
        if(!existe.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.save(post));// 201 = criado; 200 = deu certo
    }
}
