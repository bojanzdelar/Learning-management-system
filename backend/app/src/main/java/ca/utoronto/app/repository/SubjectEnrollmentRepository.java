package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.SubjectEnrollment;

@Repository
public interface SubjectEnrollmentRepository extends JpaRepository<SubjectEnrollment, Long> {}