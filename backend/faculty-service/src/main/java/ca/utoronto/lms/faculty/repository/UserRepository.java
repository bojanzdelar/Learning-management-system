package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.User;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where cast(x.id as string) like :search "
                    + "or x.email like :search or x.firstName like :search or x.lastName like :search")
    Page<User> findContaining(Pageable pageable, String search);
}
