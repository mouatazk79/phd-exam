package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.Note;
import klaa.mouataz.edlli.model.Student;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    Note getById(Integer id);
    List<Note> getAll();
    Note save(Note note);
    void deleteById(Integer id);
    Note updateNote(Note note);
    List<Note> findAllByStudentCode(UUID studentCode);

}
