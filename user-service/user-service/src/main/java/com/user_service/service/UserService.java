package com.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user_service.entity.User;
import com.user_service.exception.ResourceAlreadyExistsException;
import com.user_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // create user
    public User createUser(User user) {

        boolean emailExists = userRepository
                .findAll()
                .stream()
                .anyMatch(u -> u.getEmail().equals(user.getEmail()));

        if (emailExists) {
            throw new ResourceAlreadyExistsException(
                    "User with this email already exists");
        }

        return userRepository.save(user);
    }

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

   
}