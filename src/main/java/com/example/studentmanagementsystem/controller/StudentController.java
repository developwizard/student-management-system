package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.impl.StudentServiceImpl;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    /**
     * Get all students and return them with view
     *
     * @return students.html page
     */
    @GetMapping
    public String getAllStudents(Model model) {
        val students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    /**
     * Create student
     *
     * @param model Student blank object
     * @return create_student.html page
     */
    @GetMapping("new")
    public String addStudent(Model model) {
        val student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    /**
     * Saves student
     *
     * @param student Student
     * @return redirect to students.html page
     */
    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
