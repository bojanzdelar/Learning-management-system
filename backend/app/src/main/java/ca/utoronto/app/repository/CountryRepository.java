package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {}
