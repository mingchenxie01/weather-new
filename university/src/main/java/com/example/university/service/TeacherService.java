package com.example.university.service;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    CommonResponse findById(String id);
    CommonResponse findAll();
    CommonResponse insert(Teacher teacher);
    CommonResponse update(String id, Teacher teacher);

    CommonResponse delete(String id);
}
