package klaa.mouataz.edlli.controllers;

import jakarta.transaction.Transactional;
import klaa.mouataz.edlli.dto.StudentRequest;
import klaa.mouataz.edlli.enumerations.Role;
import klaa.mouataz.edlli.model.CFD;
import klaa.mouataz.edlli.model.Student;
import klaa.mouataz.edlli.model.StudentCSVRecord;
import klaa.mouataz.edlli.model.User;
import klaa.mouataz.edlli.repos.StudentRepository;
import klaa.mouataz.edlli.repos.UserRepository;
import klaa.mouataz.edlli.services.StudentService;
import klaa.mouataz.edlli.services.UserCSVService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final UserCSVService userCSVService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id")Integer id){
        return studentService.getById(id);
    }
    @PostMapping("/add")
    public Student addStudent(@RequestBody StudentRequest studentRequest){
        return studentService.save(studentRequest);
    }
    @PostMapping("/add/csv")
    @Transactional
    public void addStudentUsingCSV(@RequestParam("file") MultipartFile csvFile){
        try {
            File file = convertMultipartFileToFile(csvFile);

            List<StudentCSVRecord> studentCSVRecords = userCSVService.convertCSV(file);
            for (StudentCSVRecord studentCSVRecord : studentCSVRecords) {
                if (!studentRepository.existsByUserEmail(studentCSVRecord.getEmail())) {
                    Student student=Student.builder()
                            .firstName(studentCSVRecord.getFirstName())
                            .firstNameArabic(studentCSVRecord.getFirstNameArabic())
                            .lastName(studentCSVRecord.getLastName())
                            .lastNameArabic(studentCSVRecord.getLastNameArabic())
                            .number(studentCSVRecord.getNumber())
                            .dob(studentCSVRecord.getDob())
                            .gender(studentCSVRecord.getGender())
                            .speciality(studentCSVRecord.getSpeciality())
                            .build();
                    studentRepository.save(student);
                    User user = User.builder()
                            .id(studentCSVRecord.getId())
                            .email(studentCSVRecord.getEmail())
                            .password(passwordEncoder.encode(String.valueOf(studentCSVRecord.getDob())))
                            .role(Role.STUDENT)
                            .student(student)
                            .build();
                    userRepository.save(user);

                }
            }
        } catch (Exception e) {

        }
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteById(id);
    }
    @GetMapping("/all/{speciality}")
    public List<Student> getStudentBySpeciality(@PathVariable("speciality") String speciality){
        return studentService.getStudentBySpeciality(speciality);
    }
    @GetMapping("/student/byuser/{id}")
    public Student getStudentByUserid(@PathVariable("id")Integer id){
        return studentRepository.findByUid(id);
    }
    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = File.createTempFile("temp", null);
        multipartFile.transferTo(file);
        return file;
    }
}
