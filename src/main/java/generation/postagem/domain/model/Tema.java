package generation.postagem.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity(name = "tb_tema")
public class Tema {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o id automaticamente
        private Long id;
        @NotNull
        @Min(value = 3)
        private String descricao;
//        @OneToMany(mappedBy="tema")
//        private List<Postagem> postagem;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

//        public List<Postagem> getPostagem() {
//                return postagem;
//        }

//        public void setPostagem(List<Postagem> postagem) {
//                this.postagem = postagem;
//        }
}
