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
@Setter
@Getter
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "staff_id", nullable = false)
    private String staffId;
    private Integer salary;

    @OneToMany(mappedBy = "guide",cascade = {CascadeType.PERSIST})
    private List<Student> students=new ArrayList<>();

    public Guide(String name, String staffId, Integer salary) {
        this.name = name;
        this.staffId = staffId;
        this.salary = salary;
    }
}
