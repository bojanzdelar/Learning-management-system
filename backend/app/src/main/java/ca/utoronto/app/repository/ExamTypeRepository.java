package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.ExamType;

@Repository
public interface ExamTypeRepository extends JpaRepository<ExamType, Long> {}