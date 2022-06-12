package ca.utoronto.lms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.lms.app.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {}