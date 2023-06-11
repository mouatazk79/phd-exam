package klaa.mouataz.edlli.controllers;

import jakarta.transaction.Transactional;
import klaa.mouataz.edlli.model.Note;
import klaa.mouataz.edlli.model.NoteCSVRecord;
import klaa.mouataz.edlli.model.Student;
import klaa.mouataz.edlli.model.StudentCSVRecord;
import klaa.mouataz.edlli.repos.NoteRepository;
import klaa.mouataz.edlli.repos.StudentRepository;
import klaa.mouataz.edlli.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
    private final EnseignantService enseignantService;
    @GetMapping
    public List<Note> getNotes(){
        return noteService.getAll();
    }
    @GetMapping("/note/{id}")
    public Note getNote(@PathVariable("id")Integer id){
        return noteService.getById(id);
    }
    @PostMapping("/add/{modulename}/{studentid}")
    public Note addNote(@PathVariable("modulename")String modulename,@PathVariable("studentid")UUID studentid,@RequestBody Note note){
        //note.setModule(moduleService.getById(moduleid));
        note.setModuleName(modulename);
        note.setStudent(studentRepository.findByCode(studentid));
        return noteService.save(note);
    }
    @PatchMapping("/update/enseignamt3/{id}")
    public void addEnseignant3(@PathVariable("id") Integer id){
        List<Note> notes=noteRepository.findAll();
        for (Note note:notes
             ) {
            if(note.isThereIsDifference()==true){
                note.setEnseignant3(enseignantService.getById(id).getFirstName()+" "+enseignantService.getById(id).getLastName());
            }
        }
    }
    @GetMapping("/add/moyen/student/{id}")
    public void addMoyenToStudent(@PathVariable("id")UUID id){
         List<Note> notes=noteRepository.findAll();

         float total=0;
         int number=0;
         if(!notes.isEmpty()){
        for (Note note: notes
             ) {
            if (note.getStudent().getCode().equals(id)) {
                total = total + Float.parseFloat(note.getNoteFinale());
                number=number+1;
                //   System.out.println(note);
            }
        }
        }
        Student student=studentRepository.findByCode(id);
        student.setMoyen(total/number);
        studentRepository.save(student);
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
        note.setModuleName(noteService.getById(id).getModuleName());
        note.setStudent(noteService.getById(id).getStudent());
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
        note.setModuleName(noteService.getById(id).getModuleName());
        note.setStudent(noteService.getById(id).getStudent());
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
        note.setEnseignant1(note.getEnseignant1());
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
    @PostMapping("/add/note1/csv/enseignant/{id}/module/{modulename}")
    public void addNote1UsingCSV(@PathVariable("id") Integer id,@PathVariable("modulename")String idm,@RequestParam("file") MultipartFile csvFile) throws IOException {
        File file = convertMultipartFileToFile(csvFile);
        List<NoteCSVRecord> noteCSVRecords = noteCSVService.convertCSV(file);
        for (NoteCSVRecord noteCSVRecord :noteCSVRecords
             ) {
          Note note=  Note.builder().
            enseignant1(enseignantService.getById(id).getFirstName()+" "+enseignantService.getById(id).getLastName())
                    .note1(noteCSVRecord.getNote())
                  .moduleName(idm)
                    .student(studentRepository.findByCode(UUID.fromString(noteCSVRecord.getCode())))
                    .build();
          noteRepository.save(note);
            System.out.println(noteCSVRecord);

        }
    }
    @PostMapping("/add/note2/csv/enseignant/{id}/module/{idm}")
    public void addNote2UsingCSV(@PathVariable("id") Integer id,@PathVariable("idm")String idm,@RequestParam("file") MultipartFile csvFile) throws IOException {
        File file = convertMultipartFileToFile(csvFile);
        List<NoteCSVRecord> noteCSVRecords = noteCSVService.convertCSV(file);
        for (NoteCSVRecord noteCSVRecord :noteCSVRecords
        ) {
            Note note=noteRepository.findByModuleNameAndStudent_Code(idm,UUID.fromString(noteCSVRecord.getCode()));
            note.setEnseignant2(enseignantService.getById(id).getFirstName()+" "+enseignantService.getById(id).getLastName());
            note.setNote2(noteCSVRecord.getNote());
            float note1=Integer.parseInt(note.getNote1());
            float note2=Integer.parseInt(noteCSVRecord.getNote());
            float diff=note1-note2;
            if(diff>=(3)||diff<=(-3)){
                note.setNoteFinale(null);
                note.setThereIsDifference(true);
            }else {
                note.setThereIsDifference(false);
                note.setNoteFinale(String.valueOf(Float.max(note1,note2)));
            }
            noteRepository.save(note);
            //System.out.println(noteCSVRecord);

        }
    }
    @PostMapping("/add/note3/csv/enseignant/{id}/module/{idm}")
    public void addNote3UsingCSV(@PathVariable("id") Integer id,@PathVariable("idm")String idm,@RequestParam("file") MultipartFile csvFile) throws IOException {
        File file = convertMultipartFileToFile(csvFile);
        List<NoteCSVRecord> noteCSVRecords = noteCSVService.convertCSV(file);
        for (NoteCSVRecord noteCSVRecord :noteCSVRecords
        ) {
            Note note=noteRepository.findByModuleNameAndStudent_Code(idm,UUID.fromString(noteCSVRecord.getCode()));
            note.setEnseignant3(enseignantService.getById(id).getFirstName()+" "+enseignantService.getById(id).getLastName());
            note.setNote3(noteCSVRecord.getNote());
            float note1=Integer.parseInt(note.getNote1());
            float note2=Integer.parseInt(note.getNote2());
            float note3=Integer.parseInt(noteCSVRecord.getNote());
            note.setNoteFinale(String.valueOf(Float.max(Float.max(note1,note2),note3)));
            note.setThereIsDifference(true);
            noteRepository.save(note);
            //System.out.println(noteCSVRecord);

        }
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        }
        return file;
    }
}
