package com.example.studentcrud.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentcrud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Find students by department
    List<Student> findByDepartment(String department);

    // Find students by age
    List<Student> findByAge(int age);

    // Pagination
    Page<Student> findAll(Pageable pageable);
}