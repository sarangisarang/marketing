package com.example.demo.student;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "irakli",
                        "basiladze@mail.com",
                        LocalDate.of(1983, Month.APRIL, 3),
                        38
                )
        );
    }
}