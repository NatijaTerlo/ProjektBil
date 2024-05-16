package org.example.service;

import org.example.models.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;


    public void createUser(String name, String email, String password) {
        userRepository.createUser(name, email, password);
    }

    public User validateUser(String email, String password) {
        return userRepository.validateUser(email, password);
    }
}
