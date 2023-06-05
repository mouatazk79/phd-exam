package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findAdminById(Integer id);
    Admin findByUser_Email(String email);
    Admin findByUid(Integer id);
}
