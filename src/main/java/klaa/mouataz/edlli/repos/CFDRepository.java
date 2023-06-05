package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.model.CFD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CFDRepository extends JpaRepository<CFD,Integer> {
    CFD findCFDById(Integer id);
    CFD  findByUser_Email(String email);
    CFD findByUser_Id(Integer id);
}
