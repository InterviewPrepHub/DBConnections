package com.db.connection.DBConnections.TestMySQLConnection.UserService.repository;

import com.db.connection.DBConnections.TestMySQLConnection.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
