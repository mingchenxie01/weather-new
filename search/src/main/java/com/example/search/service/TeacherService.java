package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface TeacherService {
    Map<Integer, Map[]> fetchAllStudentById(List<Integer> ids);
}
