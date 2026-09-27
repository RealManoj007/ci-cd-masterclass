package com.infy.jpatest.repository;

import com.infy.jpatest.entity.Teacher;
import com.infy.jpatest.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
