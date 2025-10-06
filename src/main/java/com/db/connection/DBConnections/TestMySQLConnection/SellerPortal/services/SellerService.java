package com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.services;

import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities.Seller;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller createOrUpdateSeller(Seller sellerInput) {
        Seller existingSeller = sellerRepository.findByName(sellerInput.getName());
        long now = Instant.now().toEpochMilli();

        if (existingSeller != null) {
            existingSeller.setUpdatedAt(now);
            // Optionally update other fields, e.g.: existingSeller.setName(sellerInput.getName());
            return sellerRepository.save(existingSeller);
        } else {
            sellerInput.setCreatedAt(now);
            sellerInput.setUpdatedAt(now);
            return sellerRepository.save(sellerInput);
        }
    }
}
