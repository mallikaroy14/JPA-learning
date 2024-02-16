package com.bajaj.jpalearning.controller;

import com.bajaj.jpalearning.beans.ResponseHandler;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.models.Product;
import com.bajaj.jpalearning.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @PostMapping("/")
    public Object create(@RequestBody Product product) {
        Object product1 = productServices.create(product);
        if (product1 != null) {
            return ResponseHandler.createResponse("Product added", HttpStatus.CREATED, product1);
        }
        return ResponseHandler.createResponse("Product already exist", HttpStatus.CONFLICT, null);

    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.createResponse("Product found", HttpStatus.OK, productServices.getAll());

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Product product = productServices.get(id);
        return ResponseHandler.createResponse("Product Found", HttpStatus.OK, product);
    }


    @GetMapping("/productCode")
    public ResponseEntity<?> getByProductCode(@PathVariable String productCode) {
        List<Product> product = productServices.getByProductCode(productCode);
        return ResponseHandler.createResponse("Product Found", HttpStatus.OK, product);
    }
}
