package ca.utoronto.lms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.lms.app.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {}