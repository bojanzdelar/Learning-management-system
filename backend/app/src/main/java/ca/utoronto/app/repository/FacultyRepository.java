package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {}