package br.com.etechoracio.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_COMENTARIO")
public class Comentario {

    @Id
    @Column(name = "ID_COMENTARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_CONTEUDO")
    private String conteudo;

    @Column(name = "TX_AUTOR")
    private String autor;

    @Column(name = "DT_CRIACAO")
    private LocalDateTime criacao;

    /*@ManyToOne
    @JoinColumn( name = "ID_POST", nullable = false)
    private Post post;
    */
}
