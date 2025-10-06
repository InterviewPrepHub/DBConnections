package com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     @ManyToOne(fetch = FetchType.LAZY)
        - Indicates that many products can be linked to one seller.
        - FetchType.LAZY means the Seller data is not loaded from the database when the Product is retrieved;
          it is loaded only when the seller field is accessed. This improves performance by avoiding unnecessary
          data loading if the seller details are not always needed when loading products.
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    //Handles multiple S3 image URLs for each product
    @ElementCollection(fetch = FetchType.LAZY)      //image URLs are loaded from the database only when the accessor (getImageUrls()) is called—this is efficient, avoiding unnecessary data loading.
    @CollectionTable(
            name = "product_image_urls",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Column(name = "image_url")
    private List<String> imageUrls;     // Stores S3 URLs for images

    @Column(name = "created_at", nullable = false)
    private long createdAt;

    @Column(name = "updated_at", nullable = false)
    private long updatedAt;
}


/*
When using FetchType.LAZY, related data is loaded from the database only when needed, not upfront.

Example:
Suppose a Product has a reference to its Seller:
---------------------------------------------------------------------------
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "seller_id")
private Seller seller;
---------------------------------------------------------------------------

If you query for products:
---------------------------------------------------------------------------
List<Product> products = productRepository.findAll();
---------------------------------------------------------------------------

At this point, Seller details are NOT fetched — each Product object will have a proxy for the Seller, but no actual
seller data is loaded from the database.

If you do:
---------------------------------------------------------------------------
Product product = products.get(0);
Seller seller = product.getSeller(); // This line triggers a SQL query to load the seller info for that product.
---------------------------------------------------------------------------

Why Is This Good?
Performance: If you're just displaying products and don't need seller info, you don't waste time or resources fetching extra data.

Efficiency: Useful for lists or batch operations where related info is rarely shown.


 */