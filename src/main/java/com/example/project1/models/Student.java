package com.example.project1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_seq", sequenceName = "student_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private LocalDate dob;


    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "groupId")
    @JsonBackReference
    private Group group;

    public Student(Long id, String name, LocalDate dob, Group group) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.group = group;
    }
}
