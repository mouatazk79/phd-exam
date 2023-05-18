package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.CFD;
import klaa.mouataz.edlli.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {
    Message findMessageById(Integer id);

}
