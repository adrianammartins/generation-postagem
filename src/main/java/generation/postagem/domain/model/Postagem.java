
package generation.postagem.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity(name = "tb_postagem")
public class Postagem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o id automaticamente
        private Long id;
        @NotNull
        @Min(value = 5)
        private String titulo;
        @NotNull
        @Min(value = 10)
        private String texto;
        private Date dataInclusao;
        @ManyToOne
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;
        @ManyToOne
        @JoinColumn(name = "tema_id")
        private Tema tema;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getTexto() {
                return texto;
        }

        public void setTexto(String texto) {
                this.texto = texto;
        }

        public Date getDataInclusao() {
                return dataInclusao;
        }

        public void setDataInclusao(Date dataInclusao) {
                this.dataInclusao = dataInclusao;
        }

        public Usuario getUsuario() {
                return usuario;
        }

        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }

        public Tema getTema() {
                return tema;
        }

        public void setTema(Tema tema) {
                this.tema = tema;
        }
}
