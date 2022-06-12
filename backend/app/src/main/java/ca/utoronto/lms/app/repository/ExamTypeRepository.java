package ca.utoronto.lms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.lms.app.model.ExamType;

@Repository
public interface ExamTypeRepository extends JpaRepository<ExamType, Long> {}