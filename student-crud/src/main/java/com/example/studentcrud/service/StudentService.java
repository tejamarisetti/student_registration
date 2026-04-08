package com.example.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // Save Student
    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Get Student by ID
    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    // Delete Student
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }

    // Update Student
    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    // Find by Department
    public List<Student> getStudentsByDepartment(String dept) {
        return repo.findByDepartment(dept);
    }

    // Find by Age
    public List<Student> getStudentsByAge(int age) {
        return repo.findByAge(age);
    }

    // Sorting
    public List<Student> getStudentsSorted(String field) {
        return repo.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    // Pagination
    public Page<Student> getStudentsPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repo.findAll(pageable);
    }
}