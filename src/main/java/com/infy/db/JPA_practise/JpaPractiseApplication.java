package com.infy.db.JPA_practise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
//@EnableBatchProcessing
public class JpaPractiseApplication implements CommandLineRunner {

//    private final StudentRepo studentRepo;

//    public JpaPractiseApplication(StudentRepo dataSource) {
//        this.studentRepo = dataSource;
//    }

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(JpaPractiseApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
 /*
        studentRepo.createTableStudent();

        studentRepo.createStudent("0Ranjana","0rnaja@gmail.com");
        studentRepo.createStudent("1Ranjana","1rnaja@gmail.com");
        studentRepo.createStudent("2Ranjana","2rnaja@gmail.com");
        studentRepo.createStudent("3Ranjana","3rnaja@gmail.com");
        studentRepo.createStudent("4Ranjana","4rnaja@gmail.com");
        */
//        studentRepo.selectStudent();
//        studentRepo.getStudentByID(2);
    }
}