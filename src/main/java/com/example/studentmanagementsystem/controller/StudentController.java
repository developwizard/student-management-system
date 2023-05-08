package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.service.impl.StudentServiceImpl;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
