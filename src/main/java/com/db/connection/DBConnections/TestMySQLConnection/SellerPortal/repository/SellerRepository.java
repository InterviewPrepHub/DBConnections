package com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.repository;

import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findByName(String name);
}
