// package com.examly.springapp.service;

// import org.springframework.data.domain.Page;
// import java.util.*;
// import com.examly.springapp.model.User;

// public interface UserService {

//     User addUser(User user);

//     List<User> getAllUsers();

//     Page<User> getUsersByRole(String role, int page, int size);
// }

package com.examly.springapp.service;

import org.springframework.data.domain.Page;
import java.util.*;
import com.examly.springapp.model.User;

public interface UserService {


    User addUser(User user);
    List<User> getAllUsers();
    Page<User> getUsersByRole(String role, int page, int size);

    User getUserById(Long id);
    User updateUser(Long id, User user);
    Page<User> getUsers(int page, int size);
}