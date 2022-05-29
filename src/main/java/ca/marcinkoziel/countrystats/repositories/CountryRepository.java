package ca.marcinkoziel.countrystats.repositories;

import ca.marcinkoziel.countrystats.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
