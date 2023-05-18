package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student getStudentById(Integer id);
    List<Student> getStudentBySpeciality(String speciality);
//    @Query("SELECT  s.firstName ,s. FROM Student s INNER JOIN Note n ON s.studentcode =n.studentcode where n.thereIsDifference = true")
//    List<Student> getLevel3Students();
}
