package com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.dto;

import com.db.connection.DBConnections.TestMySQLConnection.SellerPortal.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPageResponse {

    private List<Product> products;
    private Long nextCursor; // Pass this value in the next request for the next page

}
