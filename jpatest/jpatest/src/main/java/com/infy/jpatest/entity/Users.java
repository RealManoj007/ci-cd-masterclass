package com.infy.jpatest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    @Column(name="registration_date")
    private LocalDate registrationDate;

    //param constructotor
    public Users(String username, String email, LocalDate registrationDate) {
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
    }
}
