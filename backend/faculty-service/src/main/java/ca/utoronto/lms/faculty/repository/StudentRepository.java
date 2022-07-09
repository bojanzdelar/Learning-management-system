package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.Student;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or x.firstName like :search or x.lastName like :search "
                    + "or x.index like :search or cast(x.yearOfEnrollment as string) like :search)")
    Page<Student> findContaining(Pageable pageable, String search);

    Student findByThesisId(Long thesisId);
}
