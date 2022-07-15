package ca.utoronto.lms.subject.repository;

import ca.utoronto.lms.shared.repository.BaseRepository;
import ca.utoronto.lms.subject.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends BaseRepository<Subject, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search or x.name like :search "
                    + "or x.syllabus like :search or cast(x.semester as string) like :search "
                    + "or cast(x.ects as string) like :search)")
    Page<Subject> findContaining(Pageable pageable, String search);

    List<Subject> findByStudyProgramIdAndDeletedFalseOrderBySemesterAscNameAsc(Long id);

    List<Subject> findByProfessorIdOrAssistantIdAndDeletedFalseOrderBySemesterAscNameAsc(
            Long professorId, Long assistantId);

    List<Subject> findBySubjectEnrollmentsStudentIdAndDeletedFalse(Long studentId);
}
