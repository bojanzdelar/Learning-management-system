package ca.utoronto.lms.exam.repository;

import ca.utoronto.lms.exam.model.ExamTerm;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTermRepository extends BaseRepository<ExamTerm, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where cast(x.id as string) like :search "
                    + " or cast(x.startTime as string) like :search or cast(x.endTime as string) like :search")
    Page<ExamTerm> findContaining(Pageable pageable, String search);
}
