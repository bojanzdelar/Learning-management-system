package ca.utoronto.lms.exam.repository;

import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExamTermRepository extends BaseRepository<ExamTerm, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or cast(x.startTime as string) like :search or cast(x.endTime as string) like :search)")
    Page<ExamTerm> findContaining(Pageable pageable, String search);

    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and x.exam.subjectId in :subjectIds "
                    + "and not x.id in :registeredExamTermIds "
                    + "and :date between x.examPeriod.registrationStartDate and x.examPeriod.registrationEndDate "
                    + "and (cast(x.id as string) like :search "
                    + "or cast(x.startTime as string) like :search or cast(x.endTime as string) like :search)")
    Page<ExamTerm> findRegistrableContaining(
            List<Long> subjectIds,
            List<Long> registeredExamTermIds,
            LocalDate date,
            Pageable pageable,
            String search);

    List<ExamTerm> findByExamSubjectIdAndDeletedFalseOrderByStartTimeDesc(Long subjectId);

    List<ExamTerm> findByExamSubjectIdInAndDeletedFalseOrderByStartTimeDesc(List<Long> subjectId);

    List<ExamTerm> findByExamSubjectIdInAndExamRealizationsIdInAndDeletedFalse(
            List<Long> subjectIds, List<Long> examRealizationsIds);
}
