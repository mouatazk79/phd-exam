package klaa.mouataz.edlli.bootstrap;

import jakarta.transaction.Transactional;
import klaa.mouataz.edlli.model.StudentCSVRecord;
import klaa.mouataz.edlli.model.User;
import klaa.mouataz.edlli.repos.EnseignantRepository;
import klaa.mouataz.edlli.repos.NoteRepository;
import klaa.mouataz.edlli.repos.StudentRepository;
import klaa.mouataz.edlli.repos.UserRepository;
import klaa.mouataz.edlli.services.UserCSVService;
import klaa.mouataz.edlli.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class Data implements CommandLineRunner {
//    private final EnseignantRepository enseignantRepository;
//    private final StudentRepository studentRepository;
//    private final StudentRepository noteRepository;
    @Override
    public void run(String... args) throws Exception {
      // System.out.println(noteRepository.findAllOrderByMoyenDesc());
    }
//    private final UserCSVService userCSVService;
//    private final UserRepository userRepository;
//    private final UserService userService;
//   @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        //System.out.println("hello from here");
//       // userService.getAll().forEach(user -> System.out.println(user.getEmail()));
//
////        File file= ResourceUtils.getFile("src/main/resources/MOCK_DATA.csv");
////        List<StudentCSVRecord> studentCSVRecords=userCSVService.convertCSV(file);
////        studentCSVRecords.forEach(studentCSVRecord -> userRepository.save(User.builder().id(studentCSVRecord.getId()).email(studentCSVRecord.getEmail()).password(studentCSVRecord.getPassword()).build()));
//
//
//    }
}
