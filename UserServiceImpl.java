// package com.examly.springapp.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.*;
// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.User;
// import com.examly.springapp.repository.UserRepository;
// import java.util.*;
// @Service
// public class UserServiceImpl implements UserService {

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public User addUser(User user) {
//         return userRepository.save(user);
//     }

//     @Override
//     public Page<User> getUsersByRole(String role, int page, int size) {
//         Pageable pageable = PageRequest.of(page, size);
//         return userRepository.findByRole(role, pageable);
//     }

//     @Override
//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }
// }
package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // EXISTING — DO NOT CHANGE
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // EXISTING — DO NOT CHANGE
    @Override
    public Page<User> getUsersByRole(String role, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findByRole(role, pageable);
    }

    // EXISTING — DO NOT CHANGE
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());

        return userRepository.save(existing);
    }


    @Override
    public Page<User> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }
}