package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.model.VDoyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VDoyenRepository extends JpaRepository<VDoyen,Integer> {
    VDoyen findVDoyenById(Integer id);
}
