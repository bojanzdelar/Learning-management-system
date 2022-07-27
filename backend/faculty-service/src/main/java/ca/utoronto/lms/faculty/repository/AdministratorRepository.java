package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends BaseRepository<Administrator, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or x.firstName like :search or x.lastName like :search)")
    Page<Administrator> findContaining(Pageable pageable, String search);

    Optional<Administrator> findByUserId(Long userId);
}
