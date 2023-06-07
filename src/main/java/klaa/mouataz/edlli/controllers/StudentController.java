package klaa.mouataz.edlli.controllers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.transaction.Transactional;
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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    public List<StudentCSVRecord> addStudentUsingCSV(@RequestParam("file") MultipartFile csvFile) {
        try {
            // Save the uploaded file to a temporary location
            File file = saveUploadedFile(csvFile);

            // Convert the CSV file to a list of StudentCSVRecord objects
            List<StudentCSVRecord> studentCSVRecords = convertCSV(file);

            // Save the records to the database
            saveToDatabase(studentCSVRecords);

            return studentCSVRecords;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception and return an appropriate response
        }
//        try  {
//            File file = convertMultipartFileToFile(csvFile);
//
//            List<StudentCSVRecord> studentCSVRecords = userCSVService.convertCSV(file);
//            for (StudentCSVRecord studentCSVRecord : studentCSVRecords) {
//                if (!studentRepository.existsByUserEmail(studentCSVRecord.getEmail())) {
//                    Student student=Student.builder()
//                            .firstName(studentCSVRecord.getFirstName())
//                            .firstNameArabic(studentCSVRecord.getFirstNameArabic())
//                            .lastName(studentCSVRecord.getLastName())
//                            .lastNameArabic(studentCSVRecord.getLastNameArabic())
//                            .number(studentCSVRecord.getNumber())
//                            .dob(studentCSVRecord.getDob())
//                            .gender(studentCSVRecord.getGender())
//                            .speciality(specialityRepository.getSpecialityByName(studentCSVRecord.getSpeciality()))
//                            .build();
//                    studentRepository.save(student);
//                    User user = User.builder()
//                            .id(studentCSVRecord.getId())
//                            .email(studentCSVRecord.getEmail())
//                            .password(passwordEncoder.encode(String.valueOf(studentCSVRecord.getDob())))
//                            .role(Role.STUDENT)
//                            .student(student)
//                            .build();
//                    userRepository.save(user);
//
//                }
//            }
//        } catch (Exception e) {
//
//        }

        return null;
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

    private File saveUploadedFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }

    private List<StudentCSVRecord> convertCSV(File file) throws IOException {
        FileReader reader = new FileReader(file);

        CsvToBean<StudentCSVRecord> csvToBean = new CsvToBeanBuilder<StudentCSVRecord>(reader)
                .withType(StudentCSVRecord.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        List<StudentCSVRecord> studentCSVRecords = csvToBean.parse();

        return studentCSVRecords;
    }

    private void saveToDatabase(List<StudentCSVRecord> studentCSVRecords) {
        List<Student> students = new ArrayList<>();

        for (StudentCSVRecord studentCSVRecord : studentCSVRecords) {
            if (!studentRepository.existsByUserEmail(studentCSVRecord.getEmail())) {
                Student student = Student.builder()
                        .firstName(studentCSVRecord.getFirstName())
                        .firstNameArabic(studentCSVRecord.getFirstNameArabic())
                        .lastName(studentCSVRecord.getLastName())
                        .lastNameArabic(studentCSVRecord.getLastNameArabic())
                        .number(studentCSVRecord.getNumber())
                        .dob(studentCSVRecord.getDob())
                        .gender(studentCSVRecord.getGender())
                        .speciality(specialityRepository.getSpecialityByName(studentCSVRecord.getSpeciality()))
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

            studentRepository.saveAll(students);
        }
//    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
//        File file = File.createTempFile("temp", ".csv");
//        multipartFile.transferTo(file);
//        return file;
//    }
    }
}