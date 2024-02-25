package generation.postagem.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o id automaticamente
    private Long id;
    @NotNull
    @Min(value = 3)
    private String nome;
    @NotNull
    @Email
    private String email;
    private String foto;
//    @OneToMany(mappedBy="usuario")
//    private List<Postagem> postagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

//    public List<Postagem> getPostagem() {
//        return postagem;
//    }

//    public void setPostagem(List<Postagem> postagem) {
//        this.postagem = postagem;
//    }
}
