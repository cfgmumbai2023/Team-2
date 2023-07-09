package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Product;

import java.util.List;

public interface ProductDao {
        List<Product> getAllProducts();
        List<Product> findProductByCategory(String category);
        Product getProductById(String id);
        boolean addProduct(Product product);
        boolean updateProduct(Product product);
        boolean deleteProduct(String productId);
}
