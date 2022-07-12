package ca.utoronto.lms.subject.repository;

import ca.utoronto.lms.shared.repository.BaseRepository;
import ca.utoronto.lms.subject.model.SubjectNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectNotificationRepository extends BaseRepository<SubjectNotification, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or x.name like :search or x.description like :search or cast(x.publicationDate as string) like :search)")
    Page<SubjectNotification> findContaining(Pageable pageable, String search);

    @Query(
            "select x from #{#entityName} x where x.deleted = false and x.subject.id = :subjectId "
                    + "and (cast(x.id as string) like :search "
                    + "or x.name like :search or x.description like :search or cast(x.publicationDate as string) like :search)")
    Page<SubjectNotification> findBySubjectIdContaining(
            Long subjectId, Pageable pageable, String search);

    List<SubjectNotification> findBySubjectIdAndDeletedFalseOrderByPublicationDateDesc(
            Long subjectId);
}
