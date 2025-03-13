package com.example.project1.services;
import com.example.project1.models.Student;
import com.example.project1.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateStudentService {

    private final StudentRepository studentRepository;

    public CreateStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public ResponseEntity<Student> execute(Student student) {
        if (student.getId() == null &&
                student.getName() != null &&
        student.getDob() != null &&
        student.getGroup() != null &&
        studentRepository.findById(student.getGroup().getGroupId()).isPresent()) {
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нужны все параметры");
    }

}
