package ca.utoronto.lms.exam.repository;

import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRealizationRepository extends BaseRepository<ExamRealization, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false and "
                    + "(cast(x.id as string) like :search or cast(x.score as string) like :search)")
    Page<ExamRealization> findContaining(Pageable pageable, String search);

    @Query(
            "select x from #{#entityName} x where x.deleted = false and x.examTerm.id = :subjectId and "
                    + "(cast(x.id as string) like :search or cast(x.score as string) like :search)")
    Page<ExamRealization> findByExamTermIdContaining(
            Long subjectId, Pageable pageable, String search);

    @Query(
            "select x from #{#entityName} x where x.deleted = false and x.subjectEnrollmentId in :subjectEnrollmentIds and "
                    + "(cast(x.id as string) like :search or cast(x.score as string) like :search) order by x.examTerm.startTime desc")
    Page<ExamRealization> findBySubjectEnrollmentIdsContaining(
            List<Long> subjectEnrollmentIds, Pageable pageable, String search);

    List<ExamRealization> findByExamTermIdAndDeletedFalse(Long examTermId);

    List<ExamRealization> findBySubjectEnrollmentIdInAndDeletedFalse(
            List<Long> subjectEnrollmentIds);
}
