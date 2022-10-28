package com.example.university.repository.impl;

import com.example.university.domain.entity.Teacher;
import com.example.university.repository.TeacherCustomRep;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class TeacherCustomRepImpl implements TeacherCustomRep {
    private final EntityManager entityManager;
    @Autowired
    public TeacherCustomRepImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Teacher insert(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher tea) {
        entityManager.merge(tea);
        return tea;
    }
}
