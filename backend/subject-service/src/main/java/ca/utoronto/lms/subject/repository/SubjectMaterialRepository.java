package ca.utoronto.lms.subject.repository;

import ca.utoronto.lms.shared.repository.BaseRepository;
import ca.utoronto.lms.subject.model.SubjectMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMaterialRepository extends BaseRepository<SubjectMaterial, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where cast(x.id as string) like :search "
                    + "or x.name like :search or x.description like :search or cast(x.publicationDate as string) like :search")
    Page<SubjectMaterial> findContaining(Pageable pageable, String search);
}
