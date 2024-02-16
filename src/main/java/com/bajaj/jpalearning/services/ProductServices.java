package com.bajaj.jpalearning.services;

import com.bajaj.jpalearning.exceptions.EntityNotFoundException;
import com.bajaj.jpalearning.models.Product;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServices {

    @Autowired
    ProductRepository productRepository;

    public Object create(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(Long id)
    {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            return product;
        }
        throw new EntityNotFoundException("Product with this given id not present");
    }

    public List<Product> getByProductCode(String productCode)
    {
        Optional<List<Product>> productOptional = productRepository.findByProductCode(productCode);
        if (productOptional.isPresent()) {
            List<Product> product = productOptional.get();
            return product;
        }
        throw new EntityNotFoundException("Product with this given id not present");
    }

}
