package ca.utoronto.lms.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.lms.faculty.model.StudyProgram;

@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {}
