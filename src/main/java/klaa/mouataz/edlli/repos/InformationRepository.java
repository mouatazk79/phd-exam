package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InformationRepository extends JpaRepository<News,Integer> {
    News findInformationById(Integer id);
}
