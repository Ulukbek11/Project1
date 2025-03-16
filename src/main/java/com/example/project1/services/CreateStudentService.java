package com.example.project1.services;
import com.example.project1.models.Student;
import com.example.project1.repositories.GroupRepository;
import com.example.project1.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateStudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public CreateStudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }


    public ResponseEntity<Student> execute(Student student) {
        if (student.getId() == null &&
            student.getName() != null &&
            student.getDob() != null &&
            student.getGroup() != null &&
            student.getGroup().getGroupId() != null &&
                groupRepository.findById(student.getGroup().getGroupId()).isPresent()) {
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нужны все параметры");
    }

}
