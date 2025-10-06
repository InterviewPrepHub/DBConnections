package com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.repository;

import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBySellerId(Long sellerId);


    @Query("SELECT p FROM Product p WHERE p.seller.id = :sellerId"
            + " AND (:cursor IS NULL OR p.id > :cursor)"
            + " ORDER BY p.id ASC")
    List<Product> findNextPageBySellerId(
            @Param("sellerId") Long sellerId,
            @Param("cursor") Long cursor,
            Pageable pageable
    );

    default List<Product> findFirstPageBySellerId(Long sellerId, Pageable pageable) {
        return findNextPageBySellerId(sellerId, null, pageable);
    }

}

