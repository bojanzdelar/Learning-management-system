package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {}