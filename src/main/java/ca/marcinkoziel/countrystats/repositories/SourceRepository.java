package ca.marcinkoziel.countrystats.repositories;

import ca.marcinkoziel.countrystats.beans.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SourceRepository extends JpaRepository<Source, Long> {

    List<Source> findAllByIdIn(List<Long> ids);

}
