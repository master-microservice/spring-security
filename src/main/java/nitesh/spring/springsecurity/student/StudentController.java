package nitesh.spring.springsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jone"),
            new Student(3, "Anne Hathaway"),
            new Student(4, "Mia Minnes"),
            new Student(5, "Ben")
    );

    @GetMapping({"/{studentId}"})
    public Student getStudent(@PathVariable("studentId") int studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId == student.getStudentId())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));

    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
