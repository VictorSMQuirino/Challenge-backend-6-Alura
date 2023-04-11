package alura.challenge6.repository;

import alura.challenge6.domain.model.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Page<Tutor> findAllByAtivoTrue(Pageable pageable);

    boolean existsByIdAndAtivoTrue(Long id);
}
