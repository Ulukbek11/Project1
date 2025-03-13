package com.example.project1.services;

import com.example.project1.models.Student;
import com.example.project1.repositories.StudentRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class GetStudentService {

    private final StudentRepository studentRepository;

    public GetStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + studentId));
    }
}
