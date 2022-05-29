package ca.marcinkoziel.countrystats.repositories;

import ca.marcinkoziel.countrystats.beans.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByNameContainingIgnoreCase(String name);
    List<Tag> findAllByIdIn(List<Long> ids);
}
