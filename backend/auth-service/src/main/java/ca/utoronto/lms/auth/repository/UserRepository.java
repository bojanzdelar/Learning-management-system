package ca.utoronto.lms.auth.repository;

import ca.utoronto.lms.auth.model.User;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search or x.username like :search)")
    Page<User> findContaining(Pageable pageable, String search);

    Optional<User> findByUsername(String username);
}
