package com.infy.jpatest;

import com.infy.jpatest.entity.Guide;
import com.infy.jpatest.entity.Student;
import com.infy.jpatest.entity.Teacher;
import com.infy.jpatest.entity.Users;
import com.infy.jpatest.repository.GuideRepository;
import com.infy.jpatest.repository.StudentRepository;
import com.infy.jpatest.repository.TeacherRepository;
import com.infy.jpatest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final GuideRepository guideRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public DataLoader(UserRepository userRepository,GuideRepository guideRepository,
                      TeacherRepository teacherRepository,
                      StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.guideRepository = guideRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;

    }

    @Override
    @Transactional
    public void run(String... args) {
        if (userRepository.count() == 0) {
//            List<Users> users = List.of(new Users("john_doe","jogn@gmail.com", LocalDate.now()),
//                    new Users("jane_smith","jane@gmail.com", LocalDate.now()),
//                    new Users("alice_jones","alice@gmail.com", LocalDate.now()),
//                    new Users("bob_brown","bob@gmail.com", LocalDate.now()));
//            userRepository.saveAll(users);

//            Users johnDoe = userRepository.save(new Users("john_doe", "jogn@gmail.com", LocalDate.now()));
//
//            //updating student name
//            johnDoe.setUsername("john_updated");
//            userRepository.save(johnDoe);

            Teacher teacher1 = new Teacher("Ashok","English");
            Teacher teacher2 = new Teacher("Suresh","Maths");
//            teacherRepository.saveAll(List.of(teacher1,teacher2));

            Guide guide1 = new Guide("Mike","1",12000);
            Guide guide2 = new Guide("Anna","2",15000);
//            guideRepository.saveAll(List.of(guide1,guide2));

            Student student1 = new Student("Tom","Physics",guide1,teacher1);
            Student student2 = new Student("Jerry","Chemistry",guide1,teacher2);

//            guide1.getStudents().add(student1);
//            guide1.getStudents().add(student2);
            guide1.setStudents(List.of(student1,student2));
//            guide2.setStudents(List.of(student1,student2));

            guideRepository.save(guide1);
            guideRepository.save(guide2);

            teacher1.getStudents().add(student2);
            teacher1.getStudents().add(student1);
            teacher2.getStudents().add(student1);

//            teacherRepository.save(teacher1);

            studentRepository.saveAll(List.of(student1,student2));


            System.err.println("====================Data Loaded===================");
            Student student = studentRepository.findById(1L).get();
            System.err.println(student);
        }
    }
}

