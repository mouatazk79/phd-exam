package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.dto.StudentRequest;
import klaa.mouataz.edlli.model.Student;
import klaa.mouataz.edlli.repos.StudentRepository;
import klaa.mouataz.edlli.repos.UserRepository;
import klaa.mouataz.edlli.services.StudentService;
import klaa.mouataz.edlli.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UserService userService;
    @Override
    public Student getById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(StudentRequest studentRequest) {
        userService.save(studentRequest.getUser());
        Student newStudent=Student.builder().
                firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
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

    @Override
    public void deleteById(Integer id) {
           studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentBySpeciality(String speciality){
        return studentRepository.getStudentBySpeciality(speciality);
    }
    @Override
    public Student updateStudent(Student student) {

        return studentRepository.save(student);
    }
}
