package com.example.university.repository;

import com.example.university.domain.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCustomRep {
    Student insert(Student student);
    Student update(Student stu);
}
