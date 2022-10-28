package com.example.university.repository;

import com.example.university.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String>, StudentCustomRep {
}
