package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.model.Note;
import klaa.mouataz.edlli.repos.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteService{
    private final NoteRepository noteRepository;
    public Note getById(Integer id) {
        return noteRepository.findNoteById(id);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(Integer id) {
        noteRepository.deleteById(id);
    }

    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> findAllByStudentCode(UUID studentCode) {
        return noteRepository.findAllByStudentCode(studentCode);
    }
}
