package com.techjs.cloud.product.catalogue.repositories;

import com.techjs.cloud.product.catalogue.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
