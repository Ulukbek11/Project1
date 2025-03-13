package com.example.project1.controllers;

import com.example.project1.models.Student;
import com.example.project1.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final CreateStudentService createStudentService;
    private final GetStudentService getStudentService;
    private final UpdateStudentService updateStudentService;
    private final DeleteStudentService deleteStudentService;
    public StudentController(CreateStudentService createStudentService,
                             GetStudentService getStudentService,
                             UpdateStudentService updateStudentService,
                             DeleteStudentService deleteStudentService) {
        this.createStudentService = createStudentService;
        this.getStudentService = getStudentService;
        this.updateStudentService = updateStudentService;
        this.deleteStudentService = deleteStudentService;
    }






    @PostMapping
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
        return createStudentService.execute(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return getStudentService.execute(id);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long studentId){
        return deleteStudentService.execute(studentId);
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId,
                              @RequestBody Student newStudent){
        return updateStudentService.execute(studentId, newStudent);
    }
}
