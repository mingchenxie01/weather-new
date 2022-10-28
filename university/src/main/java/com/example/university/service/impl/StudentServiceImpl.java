package com.example.university.service.impl;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Student;
import com.example.university.exception.ResourceNotFindException;
import com.example.university.repository.StudentRepository;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public CommonResponse findById(String id) {
        Optional<Student> stu = studentRepository.findById(id);
        if(!stu.isPresent()){
            throw new ResourceNotFindException("...");
        }
        return new CommonResponse(0, new Date(), stu.get());
    }

    @Override
    @Transactional
    public CommonResponse findAll() {
        List<Student> stuList = studentRepository.findAll();
        return new CommonResponse(0, new Date(), stuList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Student stu) {
        Student student = studentRepository.insert(stu);
        return new CommonResponse(0, new Date(), student.getId());
    }


    @Override
    @Transactional
    public CommonResponse update(String id, Student stu) {
        Student updateStu = studentRepository.findById(id).get();
        updateStu.setName(stu.getName());
        Student student = studentRepository.update(updateStu);
        return new CommonResponse(0, new Date(), student.getId());
    }

    @Override
    @Transactional
    public CommonResponse delete(String id) {
        Optional<Student> stu = studentRepository.findById(id);
        if(!stu.isPresent()){
            throw new ResourceNotFindException("...");
        }
        studentRepository.delete(stu.get());
        return new CommonResponse(0, new Date(), stu.get());
    }
}
