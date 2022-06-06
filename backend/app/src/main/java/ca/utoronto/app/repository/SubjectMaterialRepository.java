package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.SubjectMaterial;

@Repository
public interface SubjectMaterialRepository extends JpaRepository<SubjectMaterial, Long> {}
