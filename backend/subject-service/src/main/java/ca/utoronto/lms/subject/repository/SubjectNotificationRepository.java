package ca.utoronto.lms.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.lms.subject.model.SubjectNotification;

@Repository
public interface SubjectNotificationRepository extends JpaRepository<SubjectNotification, Long> {}
