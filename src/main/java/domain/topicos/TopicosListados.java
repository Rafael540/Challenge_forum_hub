package domain.topicos;

import jakarta.validation.constraints.NotBlank;

public record TopicosListados(


        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotBlank
        String curso
) {
    public TopicosListados(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getAutor(), topico.getCurso());

    }
}
