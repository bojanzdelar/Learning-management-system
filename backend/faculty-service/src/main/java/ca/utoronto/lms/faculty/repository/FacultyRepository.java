package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.Faculty;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends BaseRepository<Faculty, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search or x.name like :search "
                    + "or x.description like :search or x.email like :search)")
    Page<Faculty> findContaining(Pageable pageable, String search);
}
