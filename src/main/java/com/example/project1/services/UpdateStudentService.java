package com.example.project1.services;

import com.example.project1.models.Student;
import com.example.project1.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UpdateStudentService {

    private final StudentRepository studentRepository;

    public UpdateStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<Student> execute(Long studentId, Student newStudent) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found with id: " + studentId));

        if(newStudent.getName() != null &&
                newStudent.getName().length() > 0 &&
        !Objects.equals(newStudent.getName(), student.getName())){
            student.setName(newStudent.getName());
        }

        if(newStudent.getDob() != null){
            student.setDob(newStudent.getDob());
        }

        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }


}
