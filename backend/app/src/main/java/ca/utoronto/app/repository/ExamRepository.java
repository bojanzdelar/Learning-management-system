package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {}