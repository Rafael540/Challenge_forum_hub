package domain.topicos;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Normalized;

public record AtualizacaoTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotBlank
        String curso
) {
    public AtualizacaoTopico(AtualizacaoTopico dados){
        this(dados.titulo(), dados.mensagem(), dados.autor() ,dados.curso());
    }
}
