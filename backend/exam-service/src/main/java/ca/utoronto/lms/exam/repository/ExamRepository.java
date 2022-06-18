package ca.utoronto.lms.exam.repository;

import ca.utoronto.lms.exam.model.Exam;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends BaseRepository<Exam, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where cast(x.id as string) like :search "
                    + "or x.name like :search or x.description like :search "
                    + "or cast(x.minimumScore as string) like :search or cast(x.maximumScore as string) like :search")
    Page<Exam> findContaining(Pageable pageable, String search);
}
