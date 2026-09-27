package com.infy.jpatest.repository;

import com.infy.jpatest.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Transactional
    Integer deleteByUsername(String username);
}
