package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * Retrieves all students from DB
     *
     * @return Students list
     */
    List<Student> getAllStudents();

    /**
     * Saves student in DB
     *
     * @param student Student to save
     * @return Saved student
     */
    Student saveStudent(Student student);

    /**
     * Finds student by ID
     *
     * @param id Student ID
     * @return Student
     */
    Student getStudentById(Long id);
}
