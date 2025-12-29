package domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TopicosRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByCursoAndDataCriacaoBetween(
            String curso,
            LocalDateTime inicio,
            LocalDateTime fim,
            Pageable pageable

    );
}
