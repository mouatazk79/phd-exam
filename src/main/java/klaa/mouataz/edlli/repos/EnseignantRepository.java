package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
    Enseignant findEnseignantById(Integer id);
    Enseignant  findByUser_Email(String email);
    @Query("SELECT e FROM Enseignant e WHERE e.user.id = :userId")
    Enseignant findByUserId(@Param("userId") Integer userId);
}
