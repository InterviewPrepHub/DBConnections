package com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.services;

import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.dto.ProductPageResponse;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities.Product;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities.Seller;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.repository.ProductRepository;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public List<Product> uploadProducts(Long sellerId, List<Product> products) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found"));
        for (Product product : products) {
            product.setSeller(seller);
        }
        return productRepository.saveAll(products);
    }

    public ProductPageResponse listProductsCursor(Long sellerId, Long cursor, int size) {
        // If cursor is null, fetch the first page, else fetch where id > cursor
        List<Product> products;
        if (cursor == null) {
            products = productRepository.findFirstPageBySellerId(sellerId, PageRequest.of(0, size));
        } else {
            products = productRepository.findNextPageBySellerId(sellerId, cursor, PageRequest.of(0, size));
        }
        Long nextCursor = products.isEmpty() ? null : products.get(products.size() - 1).getId();
        return new ProductPageResponse(products, nextCursor);
    }

}
