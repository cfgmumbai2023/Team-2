package com.mastercard.mdes.ecom.dao;

import com.mastercard.mdes.ecom.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
    public class ProductDaoImpl implements ProductDao {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public List<Product> getAllProducts() {
            String query = "SELECT * FROM products";
            return jdbcTemplate.query(query, this::mapRowToProduct);
        }

        @Override
        public Product getProductById(String productId) {
            String query = "SELECT * FROM products WHERE productId = ?";
            return jdbcTemplate.queryForObject(query, this::mapRowToProduct, productId);
        }

        @Override
        public List<Product> findProductByCategory(String category) {
            String query = "SELECT * FROM products WHERE category = ?";
            return jdbcTemplate.query(query, this::mapRowToProduct, category);
        }

        @Override
        public boolean addProduct(Product product) {
            try
            {
                String query =
                    "INSERT INTO products (productName, model, category, manufacturer, manufactureDate, expiryDate, price, quantity) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                jdbcTemplate.update(query, product.getProductId(), product.getProductName(),
                    product.getModel(), product.getCategory(), product.getManufacturer(), product.getManufactureDate(),
                    product.getExpiryDate(), product.getPrice());
            }
            catch (Exception e){
                return false;
            }
            return true;
        }

        @Override
        public boolean updateProduct(Product product) {
            try {
                String query = "UPDATE products SET productName=?, model=?, category=?, manufacturer=?," +
                        " manufactureDate=?, expiryDate=?, price=?, WHERE productId = ?";
                jdbcTemplate.update(query, product.getProductName(),
                        product.getModel(), product.getCategory(), product.getManufacturer(), product.getManufactureDate(),
                        product.getExpiryDate(), product.getPrice(), product.getProductId());
            }
            catch (Exception e){
                return false;
            }
            return true;
        }

        @Override
        public boolean deleteProduct(String productId) {
            try
            {
                String query = "DELETE FROM products WHERE productId = ?";
                jdbcTemplate.update(query, productId);
            }
            catch (Exception e){
                return false;
            }
                return true;
        }

        private Product mapRowToProduct(ResultSet resultSet, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductId(resultSet.getString("productId"));
            product.setProductName(resultSet.getString("productName"));
            product.setModel(resultSet.getString("model"));
            product.setCategory(resultSet.getString("category"));
            product.setManufacturer(resultSet.getString("manufacturer"));
            product.setManufactureDate(resultSet.getDate("manufactureDate").toLocalDate());
            product.setExpiryDate(resultSet.getDate("expiryDate").toLocalDate());
            product.setPrice(resultSet.getLong("price"));
            return product;
        }
    }

