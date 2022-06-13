package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {}
