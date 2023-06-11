package klaa.mouataz.edlli.repos;

import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student getStudentById(Integer id);
    List<Student> findBySpecialityName(String specialityName);
    Student findByCode(UUID uuid);
    Student findByUser_Email(String email);
    Student findByUid(Integer id);
    boolean existsByUserEmail(String email);



//    @Query("SELECT  s.firstName ,s. FROM Student s INNER JOIN Note n ON s.studentcode =n.studentcode where n.thereIsDifference = true")
//    List<Student> getLevel3Students();
}
