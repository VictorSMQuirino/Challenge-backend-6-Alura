package alura.challenge6.repository;

import alura.challenge6.domain.model.Abrigo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.DoubleStream;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    Page<Abrigo> findAllByAtivoTrue(Pageable pageable);

    boolean existsByIdAndAtivoTrue(Long id);
}
