package com.db.connection.DBConnections.TestMySQLConnection.UserService.controller;

import com.db.connection.DBConnections.TestMySQLConnection.UserService.dto.UserDTO;
import com.db.connection.DBConnections.TestMySQLConnection.UserService.entity.User;
import com.db.connection.DBConnections.TestMySQLConnection.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        User user = userService.addUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
