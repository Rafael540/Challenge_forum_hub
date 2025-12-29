package domain.topicos;

import java.time.LocalDateTime;

public record DetalhamentoTopico(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        EstadoTopico topico,
        String autor,
        String curso
) {

    public DetalhamentoTopico(Topico topico){
        this(topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getEstadoTopico(),
                topico.getAutor(),
                topico.getCurso()
                );
    }
}

