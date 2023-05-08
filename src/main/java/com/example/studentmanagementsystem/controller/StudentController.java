package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.impl.StudentServiceImpl;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     * @param model Holder for model attributes
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

    /**
     * Returns the html page to update the student
     *
     * @param id    Student ID
     * @param model Holder for model attributes
     * @return update_student.html page
     */
    @GetMapping("update/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        val student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    /**
     * Updates student
     *
     * @param id      Student ID
     * @param student Updated student info
     * @return redirect to students.html page
     */
    @PostMapping("{id}")
    public String updateStudent(@PathVariable("id") Long id,
                                @ModelAttribute("student") Student student) {
        val studentFromDb = studentService.getStudentById(id);
        studentFromDb.setFirstName(student.getFirstName());
        studentFromDb.setLastName(student.getLastName());
        studentFromDb.setEmail(student.getEmail());
        studentService.saveStudent(studentFromDb);
        return "redirect:/students";
    }

    /**
     * Delete student
     *
     * @param id Student ID
     * @return redirect to students.html page
     */
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
