package klaa.mouataz.edlli.controllers;

import jakarta.transaction.Transactional;
import klaa.mouataz.edlli.model.Note;
import klaa.mouataz.edlli.model.NoteCSVRecord;
import klaa.mouataz.edlli.services.NoteCSVService;
import klaa.mouataz.edlli.services.NoteService;
import klaa.mouataz.edlli.services.UserCSVService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notes")
public class NoteController {
    private final NoteService noteService;
    private final NoteCSVService noteCSVService;
    @GetMapping
    public List<Note> getNotes(){
        return noteService.getAll();
    }
    @GetMapping("/note/{id}")
    public Note getNote(@PathVariable("id")Integer id){
        return noteService.getById(id);
    }
    @PostMapping("/add")
    public Note addNote(@RequestBody Note note){
        return noteService.save(note);
    }
//    @Transactional
//    @PostMapping("/add/csv")
//    public void addNotesCSV(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
//        File file= ResourceUtils.getFile("src/main/resources/MOCK_DATA.csv");
//        List<NoteCSVRecord> noteCSVRecords= NoteCSVService.convertCSV(file);
//        noteCSVRecords.forEach(noteCSVRecord -> noteService.save(Note.builder().id(noteCSVRecord.getId()).note1(noteCSVRecord.getNote1()).note2(noteCSVRecord.getNote2()).note3(noteCSVRecord.getNote3()).enseignant1().build()));
//    }
    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable("id")Integer id){
        noteService.deleteById(id);
    }

}
