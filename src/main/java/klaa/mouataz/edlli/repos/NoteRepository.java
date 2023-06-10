package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {
    Note findNoteById(Integer id);
    List<Note> findAllByStudentCode(UUID studentCode);
    List<Note> findByModule_NameAndThereIsDifferenceTrue(String moduleName);
    Note findByModuleNameAndStudent_Code(String moduleName,UUID code);
    List<Note> findByStudent_Code(UUID code);
}
