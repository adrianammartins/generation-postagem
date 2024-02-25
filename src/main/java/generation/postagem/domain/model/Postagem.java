package generation.postagem.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity(name = "tb_aluno")
public class Tema {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o id automaticamente
        private Long id;
        private String descricao;
        private List<Postagem> postagem;

}
