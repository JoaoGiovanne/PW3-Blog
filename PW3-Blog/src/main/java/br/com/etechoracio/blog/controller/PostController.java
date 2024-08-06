package br.com.etechoracio.blog.controller;

<<<<<<< HEAD
import br.com.etechoracio.blog.entity.Post;
import br.com.etechoracio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
=======
import br.com.etechoracio.blog.repository.PostRepository;
import br.com.etechoracio.blog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 0c5878a16f46aaf88a1fe52c04b16aed1e5329d5
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
<<<<<<< HEAD
    @Autowired //cria o objeto quando necessario
    private PostRepository repository; // o repository manipula o dado
    @GetMapping
    public List<Post> listarPosts(){
        return repository.findAll(); //retorna uma lista de posts
    }

    @GetMapping("/{id}")
    public Optional<Post> buscarPorId(@PathVariable Long id){ // é uma variavel que vai vir do path, seria a lista de id
        return repository.findById(id);
    }
}
=======

    @Autowired
    private PostRepository repository;

    @GetMapping
    public List<Post> listarPosts(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> buscarPorId(@PathVariable Long id){
        return repository.findById(id);
    }
}
>>>>>>> 0c5878a16f46aaf88a1fe52c04b16aed1e5329d5
