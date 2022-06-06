package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {}
