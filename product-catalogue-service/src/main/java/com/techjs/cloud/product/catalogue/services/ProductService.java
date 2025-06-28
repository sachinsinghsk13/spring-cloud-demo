package com.techjs.cloud.product.catalogue.services;

import com.techjs.cloud.product.catalogue.entities.Product;
import com.techjs.cloud.product.catalogue.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product p) {
        return repository.save(p);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Optional<Product> getById(Integer id) {
        return repository.findById(id);
    }

    public Product update(Integer id, Product p) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(p.getName());
                    existing.setPrice(p.getPrice());
                    existing.setCategory(p.getCategory());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
