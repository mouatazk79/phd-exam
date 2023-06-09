package klaa.mouataz.edlli.controllers;

import jakarta.transaction.Transactional;
import klaa.mouataz.edlli.model.Note;
import klaa.mouataz.edlli.model.NoteCSVRecord;
import klaa.mouataz.edlli.repos.NoteRepository;
import klaa.mouataz.edlli.repos.StudentRepository;
import klaa.mouataz.edlli.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notes")
public class NoteController {
    private final NoteService noteService;
    private final NoteRepository noteRepository;
    private final StudentRepository studentRepository;
    private final ModuleService moduleService;
    private final NoteCSVService noteCSVService;
    @GetMapping
    public List<Note> getNotes(){
        return noteService.getAll();
    }
    @GetMapping("/note/{id}")
    public Note getNote(@PathVariable("id")Integer id){
        return noteService.getById(id);
    }
    @PostMapping("/add/{moduleid}/{studentid}")
    public Note addNote(@PathVariable("moduleid")Integer moduleid,@PathVariable("studentid")UUID studentid,@RequestBody Note note){
        note.setModule(moduleService.getById(moduleid));
        note.setStudent(studentRepository.findByCode(studentid));
        return noteService.save(note);
    }
//    @PostMapping("/add/csv")
//    @Transactional
//    public void addNotesCSV(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
//        List<NoteCSVRecord> noteCSVRecords= NoteCSVService.convertCSV(file);
//        noteCSVRecords.forEach(noteCSVRecord -> noteService.save(Note.builder().id(noteCSVRecord.getId()).note1(noteCSVRecord.getNote1()).note2(noteCSVRecord.getNote2()).note3(noteCSVRecord.getNote3()).build()));
//    }
@PatchMapping("/update/{id}")
public Note updateNote(@PathVariable("id")Integer id,@RequestBody Note note){
        note.setId(id);
        float n1=Float.parseFloat(noteService.getById(id).getNote1());
        note.setNote1(String.valueOf(n1));
        float n2=Float.parseFloat(note.getNote2());
        note.setNote2(String.valueOf(n2));
        float diff=n1-n2;
        note.setEnseignant1(noteService.getById(id).getEnseignant1());
        note.setEnseignant2(note.getEnseignant2());
        if(diff>=3 || diff<=(-3) ){
            note.setThereIsDifference(true);
            note.setNoteFinale(null);
        }else {
            note.setThereIsDifference(false);
            note.setNoteFinale(String.valueOf(Float.max(n1,n2)));
        }
    return noteService.updateNote(note);
}
    @PatchMapping("/update3/{id}")
    public Note update3Note(@PathVariable("id")Integer id,@RequestBody Note note){
        note.setId(id);
        float n1=Float.parseFloat(noteService.getById(id).getNote1());
        note.setNote1(String.valueOf(n1));
        float n2=Float.parseFloat(noteService.getById(id).getNote2());
        note.setNote2(String.valueOf(n2));
        float n3=Float.parseFloat(note.getNote3());
        note.setNote3(String.valueOf(n3));
        note.setNoteFinale(String.valueOf(Float.max(Float.max(n1,n2),n3)));
        note.setEnseignant1(noteService.getById(id).getEnseignant1());
        note.setEnseignant2(noteService.getById(id).getEnseignant2());
        note.setEnseignant3(note.getEnseignant3());
        note.setThereIsDifference(true);

        return noteService.updateNote(note);
    }
    @PatchMapping("/update/note1/{id}")
    public Note updateNote1(@PathVariable("id") Integer id,@RequestBody Note note){
        note.setId(id);
        note.setNote1(note.getNote1());
        return noteService.updateNote(note);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable("id")Integer id){
        noteService.deleteById(id);
    }
    @GetMapping("/all/student/{id}")
    public List<Note> getNoteByStudent(@PathVariable("id") UUID id){
        return noteService.findAllByStudentCode(id);
    }
    @GetMapping("/alllevel3/module/{name}")
    public List<Note> getNoteByModule(@PathVariable("name") String name){
        return noteRepository.findByModule_NameAndThereIsDifferenceTrue(name);
    }

}
