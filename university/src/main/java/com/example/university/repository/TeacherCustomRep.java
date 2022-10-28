package com.example.university.repository;

import com.example.university.domain.entity.Teacher;

public interface TeacherCustomRep {
    Teacher insert(Teacher teacher);
    Teacher update(Teacher tea);
}
