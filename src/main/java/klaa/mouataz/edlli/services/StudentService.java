package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StudentRequest;
import klaa.mouataz.edlli.model.Student;
import klaa.mouataz.edlli.model.User;

import java.util.List;

public interface StudentService {
    Student getById(Integer id);
    List<Student> getAll();
    Student save(StudentRequest studentRequest);
    void deleteById(Integer id);
    Student updateStudent(Student student);
     List<Student> getStudentBySpeciality(String speciality);
}
