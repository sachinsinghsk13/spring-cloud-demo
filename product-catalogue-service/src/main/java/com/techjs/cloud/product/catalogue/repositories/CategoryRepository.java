package com.techjs.cloud.product.catalogue.repositories;

import com.techjs.cloud.product.catalogue.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
