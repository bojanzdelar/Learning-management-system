package ca.utoronto.lms.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.lms.exam.model.ExamRealization;

@Repository
public interface ExamRealizationRepository extends JpaRepository<ExamRealization, Long> {}
