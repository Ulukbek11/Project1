package com.example.project1.services;

import com.example.project1.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentService {

    private final StudentRepository studentRepository;

    public DeleteStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<String> execute(Long studentId) {
        if (studentRepository.findById(studentId).isPresent()){
            studentRepository.deleteById(studentId);
            return ResponseEntity.status(HttpStatus.OK).body("Студент успешно удален");

        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Студента не существует");

    }
}
