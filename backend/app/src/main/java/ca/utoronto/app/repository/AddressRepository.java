package ca.utoronto.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.utoronto.app.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {}
