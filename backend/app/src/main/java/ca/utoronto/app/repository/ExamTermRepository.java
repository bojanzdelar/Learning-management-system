package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.ExamTerm;

@Repository
public interface ExamTermRepository extends JpaRepository<ExamTerm, Long> {}
