package ca.marcinkoziel.countrystats.repositories;

import ca.marcinkoziel.countrystats.beans.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByImagePath(String imagePath);

}