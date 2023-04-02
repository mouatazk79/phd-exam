package klaa.mouataz.edlli.repos;

import java.util.Optional;

import klaa.mouataz.edlli.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
