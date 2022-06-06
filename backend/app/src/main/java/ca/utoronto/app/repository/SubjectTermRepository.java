package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.SubjectTerm;

@Repository
public interface SubjectTermRepository extends JpaRepository<SubjectTerm, Long> {}
