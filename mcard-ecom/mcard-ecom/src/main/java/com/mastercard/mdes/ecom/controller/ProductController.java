package com.mastercard.mdes.ecom.controller;


import com.mastercard.mdes.ecom.model.Product;
import com.mastercard.mdes.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping("/productAPI")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/saveProductDetails")
    public ResponseEntity<String> saveProductDetails(@RequestBody Product product){
        if(productService.saveProduct(product)){
            return new ResponseEntity<String>("Product details saved successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error in saving Product details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modifyProductDetails")
    public ResponseEntity<String> modifyProductDetails(@RequestBody Product product){
        if(productService.modifyProduct(product)){
            return new ResponseEntity<String>("Product details modified successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error in modifying Product details", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getAllProductByCategory/{category}")
    public ResponseEntity<List<Product>> getAllProductByCategory(@PathVariable("category") String category){
        List<Product> productList = productService.getAllProductByCategory(category);
        if(productList!=null){
            return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<Product>>(productList,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductById/{productCode}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("productCode") String productCode){
        Optional<Product> productDetail = productService.getProductById(productCode);
        if(productDetail!=null){
            return new ResponseEntity<Optional<Product>>(productDetail,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Optional<Product>>(productDetail,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        if(productList!=null){
            return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<Product>>(productList,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProduct/{productCode}")
    public ResponseEntity<String> deleteProductDetails(@PathVariable("productCode") String productCode){
        if(productService.deleteProduct(productCode)){
            return new ResponseEntity<String>("Product details deleted successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error in deleting Product details", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
