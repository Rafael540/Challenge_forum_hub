package domain.topicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name= "topico")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titulo;
        private String mensagem;
        private LocalDateTime dataCriacao = LocalDateTime.now();

        @Enumerated(EnumType.STRING)
        private EstadoTopico estadoTopico = EstadoTopico.POSTADO;
        private String autor;
        private String curso;


        public Topico(DadosCadastroTopico dados) {
            this.titulo = dados.titulo();
            this.mensagem = dados.mensagem();
            this.autor = dados.autor();
            this.curso = dados.curso();
        }

    public void atualizar(@Valid AtualizacaoTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();

        }
}
