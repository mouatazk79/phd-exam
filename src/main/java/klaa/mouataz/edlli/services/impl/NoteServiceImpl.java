package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.model.Note;
import klaa.mouataz.edlli.repos.NoteRepository;
import klaa.mouataz.edlli.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    @Override
    public Note getById(Integer id) {
        return noteRepository.findNoteById(id);
    }

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(Integer id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> findAllByStudentCode(UUID studentCode) {
        return noteRepository.findAllByStudentCode(studentCode);
    }
}
