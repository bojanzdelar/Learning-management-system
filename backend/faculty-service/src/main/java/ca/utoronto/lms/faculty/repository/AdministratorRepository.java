package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends BaseRepository<Administrator, Long> {
    @Override
    @Query("select x from #{#entityName} x where cast(x.id as string) like :search ")
    Page<Administrator> findContaining(Pageable pageable, String search);
}
