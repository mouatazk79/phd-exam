package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.dto.StudentRequest;
import klaa.mouataz.edlli.model.CFD;
import klaa.mouataz.edlli.model.Student;
import klaa.mouataz.edlli.repos.StudentRepository;
import klaa.mouataz.edlli.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;
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

}
