package ca.utoronto.lms.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.lms.exam.model.ExamPeriod;

@Repository
public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {}
