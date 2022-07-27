package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.Thesis;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThesisRepository extends BaseRepository<Thesis, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or x.name like :search or x.description like :search or x.url like :search "
                    + "or cast(x.applicationDate as string) like :search or cast (x.defenseDate as string) like :search "
                    + "or cast(x.grade as string) like :search)")
    Page<Thesis> findContaining(Pageable pageable, String search);

    Optional<Thesis> findByStudentId(Long id);
}
