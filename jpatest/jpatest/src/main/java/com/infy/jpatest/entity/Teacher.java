package com.infy.jpatest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String subject;

    @OneToMany(mappedBy = "teacher",cascade = {CascadeType.PERSIST})
    @Column(nullable = true)
    private List<Student> students=new ArrayList<>();

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }
}
