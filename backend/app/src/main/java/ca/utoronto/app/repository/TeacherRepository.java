package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {}