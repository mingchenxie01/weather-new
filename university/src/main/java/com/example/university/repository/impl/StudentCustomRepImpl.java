package com.example.university.repository.impl;

import com.example.university.domain.entity.Student;
import com.example.university.repository.StudentCustomRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class StudentCustomRepImpl implements StudentCustomRep {
    private final EntityManager entityManager;
    @Autowired
    public StudentCustomRepImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public Student insert(Student student) {
        entityManager.persist(student);// only execute insert into database
        return student;
    }

    @Override
    public Student update(Student stu) {
        entityManager.merge(stu);
        return stu;
    }

}
