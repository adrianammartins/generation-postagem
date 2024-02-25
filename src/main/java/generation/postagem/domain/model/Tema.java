package generation.postagem.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_aluno")
public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o id automaticamente
        private Long id;
        private String nome;
        private String email;
        private String foto;
        private List<Postagem> postagem;

}
