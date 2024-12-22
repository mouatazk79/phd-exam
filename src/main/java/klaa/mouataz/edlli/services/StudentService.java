package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StudentRequest;
import klaa.mouataz.edlli.model.Student;
import klaa.mouataz.edlli.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserService userService;
    public Student getById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student save(StudentRequest studentRequest) {
        userService.save(studentRequest.getUser());
        Student newStudent=Student.builder().
                firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .uid(studentRequest.getUser().getId())
                .dob(studentRequest.getDob())
                .firstNameArabic(studentRequest.getFirstNameArabic())
                .lastNameArabic(studentRequest.getLastNameArabic())
                .code(UUID.randomUUID())
                .speciality(studentRequest.getSpeciality())
                .gender(studentRequest.getGender())
                .number(studentRequest.getNumber())
                .user(studentRequest.getUser())
                .build();
        return studentRepository.save(newStudent);
    }

    public void deleteById(Integer id) {
           studentRepository.deleteById(id);
    }

    public List<Student> getStudentBySpeciality(String speciality){
        return studentRepository.findBySpecialityName(speciality);
    }
    public Student updateStudent(Student student) {

        return studentRepository.save(student);
    }
}
