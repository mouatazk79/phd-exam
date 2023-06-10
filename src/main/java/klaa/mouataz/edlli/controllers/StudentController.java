package klaa.mouataz.edlli.controllers;


import klaa.mouataz.edlli.dto.StudentRequest;
import klaa.mouataz.edlli.enumerations.Role;
import klaa.mouataz.edlli.model.Student;
import klaa.mouataz.edlli.model.StudentCSVRecord;
import klaa.mouataz.edlli.model.User;
import klaa.mouataz.edlli.repos.SpecialityRepository;
import klaa.mouataz.edlli.repos.StudentRepository;
import klaa.mouataz.edlli.repos.UserRepository;
import klaa.mouataz.edlli.services.StudentService;
import klaa.mouataz.edlli.services.UserCSVService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private  final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final UserCSVService userCSVService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SpecialityRepository specialityRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        return studentService.getById(id);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.save(studentRequest);
    }

    @PostMapping("/add/csv")
    public void addStudentUsingCSV(@RequestParam("file") MultipartFile csvFile) throws IOException {

            File file = convertMultipartFileToFile(csvFile);
            List<StudentCSVRecord> studentCSVRecords = userCSVService.convertCSV(file);
            for (StudentCSVRecord studentCSVRecord : studentCSVRecords) {
                System.out.println(studentCSVRecord);
                if (!studentRepository.existsByUserEmail(studentCSVRecord.getEmail())) {
                    Student student=Student.builder()
                            .uid(studentCSVRecord.getId())
                            .firstName(studentCSVRecord.getFirstName())
                            .firstNameArabic(studentCSVRecord.getFirstNameArabic())
                            .lastName(studentCSVRecord.getLastName())
                            .lastNameArabic(studentCSVRecord.getLastNameArabic())
                            .number(studentCSVRecord.getNumber())
                            .code(UUID.randomUUID())
                            .dob( LocalDate.parse(studentCSVRecord.getDob(),dtf))
                            .gender(studentCSVRecord.getGender())
                            .speciality(specialityRepository.getSpecialityByName(studentCSVRecord.getSpeciality()))
                            .build();
             //   System.out.println(student);
                    studentRepository.save(student);
                    User user = User.builder()
                            .id(studentCSVRecord.getId())
                            .email(studentCSVRecord.getEmail())
                            .password(passwordEncoder.encode(String.valueOf(studentCSVRecord.getDob())))
                            .role(Role.STUDENT)
                            .student(student)
                            .build();
                    userRepository.save(user);

                }else {
                    System.out.println("none");
                }
            }

    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteById(id);
    }

    @GetMapping("/all/{speciality}")
    public List<Student> getStudentBySpeciality(@PathVariable("speciality") String speciality) {
        return studentService.getStudentBySpeciality(speciality);
    }

    @GetMapping("/student/byuser/{id}")
    public Student getStudentByUserid(@PathVariable("id") Integer id) {

        return studentRepository.findByUid(id);
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        }
        return file;
    }
}
