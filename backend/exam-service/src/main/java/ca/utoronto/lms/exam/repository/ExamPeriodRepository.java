package ca.utoronto.lms.exam.repository;

import ca.utoronto.lms.exam.model.ExamPeriod;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamPeriodRepository extends BaseRepository<ExamPeriod, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search or x.name like :search "
                    + "or cast(x.registrationStartDate as string) like :search or cast(x.registrationEndDate as string) like :search "
                    + "or cast(x.examStartDate as string) like :search or cast(x.examEndDate as string) like :search)")
    Page<ExamPeriod> findContaining(Pageable pageable, String search);
}
