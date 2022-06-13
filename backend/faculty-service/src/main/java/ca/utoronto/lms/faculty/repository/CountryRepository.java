package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {}
