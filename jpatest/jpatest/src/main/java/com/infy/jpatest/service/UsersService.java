package com.infy.jpatest.service;

import com.infy.jpatest.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Integer deleteUserByUsername(String username) {
        Integer deleteByUsername = userRepository.deleteByUsername(username);
        System.err.println("Number of records deleted: " + deleteByUsername);
        return deleteByUsername;
    }

}
