package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path="api/w3s/school")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
//    @PostMapping("/student")
//    public Student saveStudent(@RequestBody Student student){
//        System.out.println(" savestudents show body " + student.getName());
//        return student;
//    }
//}
