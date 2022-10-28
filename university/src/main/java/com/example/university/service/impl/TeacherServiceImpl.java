package com.example.university.service.impl;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Teacher;
import com.example.university.exception.ResourceNotFindException;
import com.example.university.repository.TeacherRepository;
import com.example.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    @Transactional
    public CommonResponse findById(String id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(!teacher.isPresent()){
            throw new ResourceNotFindException("...");
        }
        return new CommonResponse(0, new Date(), teacher.get());
    }

    @Override
    @Transactional
    public CommonResponse findAll() {
        List<Teacher> teaList = teacherRepository.findAll();
        return new CommonResponse(0, new Date(), teaList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Teacher tea) {
        Teacher teacher = teacherRepository.insert(tea);
        return new CommonResponse(0, new Date(), teacher.getId());
    }

    @Override
    @Transactional
    public CommonResponse update(String id, Teacher tea) {
        Teacher updateTea = teacherRepository.findById(id).get();
        updateTea.setName(tea.getName());
        Teacher teacher = teacherRepository.update(updateTea);
        return new CommonResponse(0, new Date(), teacher.getId());
    }

    @Override
    @Transactional
    public CommonResponse delete(String id) {
        Optional<Teacher> tea = teacherRepository.findById(id);
        if(!tea.isPresent()){
            throw new ResourceNotFindException("...");
        }
        teacherRepository.delete(tea.get());
        return new CommonResponse(0, new Date(), tea.get());
    }
}
