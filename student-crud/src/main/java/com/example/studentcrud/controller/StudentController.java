package com.example.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Add Student
    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return service.saveStudent(s);
    }

    // Get All Students
    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    // Get Student by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }

    // Update Student
    @PutMapping
    public Student updateStudent(@RequestBody Student s) {
        return service.updateStudent(s);
    }

    // Find by Department
    @GetMapping("/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept) {
        return service.getStudentsByDepartment(dept);
    }

    // Find by Age
    @GetMapping("/age/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return service.getStudentsByAge(age);
    }

    // Sorting
    @GetMapping("/sort/{field}")
    public List<Student> sortStudents(@PathVariable String field) {
        return service.getStudentsSorted(field);
    }

    // Pagination
    @GetMapping("/page/{page}/{size}")
    public Page<Student> paginateStudents(@PathVariable int page, @PathVariable int size) {
        return service.getStudentsPaginated(page, size);
    }
}