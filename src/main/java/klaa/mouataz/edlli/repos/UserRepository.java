package klaa.mouataz.edlli.repos;

import java.util.List;
import java.util.Optional;

import klaa.mouataz.edlli.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  User findUserById(Integer integer);
  @Query("SELECT u.email ,u.role from User as u")
  List<User>  findAllUsers();

}
