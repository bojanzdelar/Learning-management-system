package ca.utoronto.lms.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.lms.faculty.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {}
