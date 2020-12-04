package nitesh.spring.springsecurity.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jone"),
            new Student(3, "Anne Hathaway"),
            new Student(4, "Mia Minnes"),
            new Student(5, "Ben")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS;
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("Register Student");
        System.out.println(student);
    }

    @DeleteMapping({"/{studentId}"})
    public void deleteStudent(@PathVariable("studentId") int studentId) {
        System.out.println("Delete Student");
        System.out.println(studentId);
    }

    @PutMapping({"/{studentId}"})
    public void updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        System.out.println("Update Student");
        System.out.printf("%s %s%n", studentId, student);
    }
}
