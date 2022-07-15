package ca.utoronto.lms.subject.repository;

import ca.utoronto.lms.shared.repository.BaseRepository;
import ca.utoronto.lms.subject.model.SubjectEnrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectEnrollmentRepository extends BaseRepository<SubjectEnrollment, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or cast(x.extraPoints as string) like :search or cast(x.grade as string) like :search)")
    Page<SubjectEnrollment> findContaining(Pageable pageable, String search);

    @Query(
            "select x from #{#entityName} x where x.deleted = false and x.subject.id = :subjectId "
                    + "and (cast(x.id as string) like :search "
                    + "or cast(x.extraPoints as string) like :search or cast(x.grade as string) like :search)")
    Page<SubjectEnrollment> findBySubjectIdContaining(
            Long subjectId, Pageable pageable, String search);

    List<SubjectEnrollment> findBySubjectIdAndDeletedFalse(Long subjectId);

    List<SubjectEnrollment> findByStudentIdAndDeletedFalse(Long studentId);

    @Query(
            "select x from #{#entityName} x where x.deleted = false and x.studentId = :studentId "
                    + "and (cast(x.id as string) like :search "
                    + "or cast(x.extraPoints as string) like :search or cast(x.grade as string) like :search)")
    Page<SubjectEnrollment> findByStudentIdContaining(
            Long studentId, Pageable pageable, String search);
}
