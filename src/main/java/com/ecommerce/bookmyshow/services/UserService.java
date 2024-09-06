package com.ecommerce.bookmyshow.services;

import com.ecommerce.bookmyshow.Models.User;
import com.ecommerce.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name, String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);
        User savedUser = null;

        if(user.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        else {
            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setPassword(bCryptPasswordEncoder.encode(password));
            savedUser =  userRepository.save(newUser);
        }

        return savedUser;

    }
}
