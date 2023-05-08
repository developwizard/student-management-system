package com.example.studentmanagementsystem;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(studentRepository.findAll().isEmpty()) {
            val students = new ArrayList<Student>();
            students.add(new Student("Ivan", "Ivanov", "ivanov@gmail.com"));
            students.add(new Student("Oleg", "Olegov", "olegov@gmail.com"));
            students.add(new Student("Tatiana", "Tanushina", "tanushina@gmail.com"));
            studentRepository.saveAll(students);
        }
    }
}
