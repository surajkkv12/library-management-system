package com.library.service;

import com.library.entity.User;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(User user) {
        User existing = userRepository.findByEmail(user.getEmail());
        if (user.getEmail() == null || user.getPassword() == null) {
            return null;
        }
        if (existing != null && existing.getPassword().equals(user.getPassword())) {
            return existing;
        }
        return null;
        
    }
    

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}