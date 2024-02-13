package com.bajaj.jpalearning.repositories;

import com.bajaj.jpalearning.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
