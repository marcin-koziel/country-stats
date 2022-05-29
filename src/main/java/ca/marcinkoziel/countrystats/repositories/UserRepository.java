package ca.marcinkoziel.countrystats.repositories;

import ca.marcinkoziel.countrystats.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameIgnoreCase(String username);
    Boolean existsByUsernameIgnoreCase(String username);

}
