package com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.controller;

import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.dto.ProductPageResponse;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities.Product;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities.Seller;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.services.ProductService;
import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller-portal")
public class SellerPortalController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private ProductService productService;

    @PostMapping("/seller")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createOrUpdateSeller(seller);
    }

    @PostMapping("/sellers/{sellerId}/products")
    public List<Product> uploadProducts(
            @PathVariable Long sellerId,
            @RequestBody List<Product> products) {
        return productService.uploadProducts(sellerId, products);
    }

    @GetMapping("/sellers/{sellerId}/products")
    public ProductPageResponse listProducts(
            @PathVariable Long sellerId,
            @RequestParam(required = false) Long cursor, // ID of last product from previous page
            @RequestParam(defaultValue = "20") int size) {
        return productService.listProductsCursor(sellerId, cursor, size);
    }

}
