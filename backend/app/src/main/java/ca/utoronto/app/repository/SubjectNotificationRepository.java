package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.SubjectNotification;

@Repository
public interface SubjectNotificationRepository extends JpaRepository<SubjectNotification, Long> {}