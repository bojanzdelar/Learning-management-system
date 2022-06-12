package ca.utoronto.lms.app.repository;

import ca.utoronto.lms.app.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {}
