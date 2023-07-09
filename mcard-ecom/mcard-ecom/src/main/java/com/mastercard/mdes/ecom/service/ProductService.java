package com.mastercard.mdes.ecom.service;


import com.mastercard.mdes.ecom.dao.ProductDaoImpl;
import com.mastercard.mdes.ecom.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    @Autowired
    private ProductDaoImpl productDAOImpl;

    public boolean saveProduct(Product product) {
        return productDAOImpl.addProduct(product);
    }

    public boolean modifyProduct(Product product) {
        return productDAOImpl.updateProduct(product);
    }

    public List<Product> getAllProductByCategory(String category) {
        List<Product> productList = productDAOImpl.findProductByCategory(category);
        return productList;
    }

    public Optional<Product> getProductById(String productCode) {
        Optional<Product> productDetailsByCategory = Optional.ofNullable(productDAOImpl.getProductById(productCode));
        return productDetailsByCategory;
    }

    public boolean deleteProduct(String productCode) {
        return productDAOImpl.deleteProduct(productCode);
    }

    public List<Product> getAllProducts() {
        List<Product> productList = productDAOImpl.getAllProducts();
        return productList;
    }
}
