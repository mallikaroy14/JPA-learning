package com.bajaj.jpalearning.repositories;

import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<List<Product>> findByProductCode(String productCode);

}
