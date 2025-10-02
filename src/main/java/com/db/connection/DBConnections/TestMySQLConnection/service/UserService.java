package com.db.connection.DBConnections.TestMySQLConnection.service;

import com.db.connection.DBConnections.TestMySQLConnection.dto.UserDTO;
import com.db.connection.DBConnections.TestMySQLConnection.entity.User;
import com.db.connection.DBConnections.TestMySQLConnection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return userRepository.save(user);
    }

    private static User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());
        user.setCreatedAt(System.currentTimeMillis());
        return user;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
