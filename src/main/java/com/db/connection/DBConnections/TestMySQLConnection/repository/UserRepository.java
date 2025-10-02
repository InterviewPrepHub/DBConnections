package com.db.connection.DBConnections.TestMySQLConnection.repository;

import com.db.connection.DBConnections.TestMySQLConnection.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
