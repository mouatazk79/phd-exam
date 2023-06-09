package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.Enseignant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
    Enseignant findEnseignantById(Integer id);
     Enseignant  findByUser_Email(String email);
    Enseignant findByUid(Integer id);
//    @Query("SELECT e from Enseignant e left join Module m on e.id=m.id")
//    List<Enseignant> findAllWithModules();
//    @Query("SELECT e FROM Enseignant e left join Enseignant t  on e.id=t.enseignant_id left join edlli._module m on e.id=m.enseig_id ")
//    List<Enseignant> findAllWithModules1();

}
