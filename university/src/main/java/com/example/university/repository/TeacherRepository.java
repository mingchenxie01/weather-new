package com.example.university.repository;

import com.example.university.domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String>, TeacherCustomRep {

}
